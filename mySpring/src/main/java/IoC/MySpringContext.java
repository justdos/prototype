package IoC;

import annotion.MyBean;
import annotion.MyConfig;
import aop.AopRegister;
import com.sun.xml.internal.ws.util.StringUtils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;

public class MySpringContext {

    public MySpringContext(Class clazz) throws Exception{
        Annotation myConfig = clazz.getAnnotation(MyConfig.class);
        if(myConfig == null) {
            throw new Exception("配置类必须注解MyConfig注解！");
        }
        MyConfig config = (MyConfig)myConfig;
        String path = config.scanPath();

        doScan(clazz, path);

    }

    private void doScan(Class clazz, String path) throws Exception {
        Collection<String> classPaths = getClassPath(clazz, path);

        String classPath = getPathByClass(clazz);
        //把有参构造方法统一后面处理
        Map<String,Class> waitInitClassMap = new HashMap<>();
        for(String c : classPaths) {

            c = c.replace(classPath.replace("/","\\").replaceFirst("\\\\",""),"").replace("\\",".").replace(".class","");

            Class<?> aClass = Class.forName(c);
            MyBean myBean = aClass.getAnnotation(MyBean.class);
            if(myBean == null) {
                continue;
            }
            Object o = null;
            String alias = myBean.alias();
            String beanName = (alias == null || alias.equals("")) ? c : alias;
            try {
                o = aClass.newInstance();
                BeanFactory.put(beanName, o);
            } catch (Exception e) {
                waitInitClassMap.put(beanName,aClass);
            }
        }
        if(!waitInitClassMap.isEmpty()) {
            for(String beanName:waitInitClassMap.keySet()) {
                try {
                    BeanFactory.put(beanName,ClassLoader.initObject(waitInitClassMap.get(beanName)));
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
            if(!BeanFactory.cycleBeanList.isEmpty()) {
                for(String beanName:waitInitClassMap.keySet()) {
                    try {
                        BeanFactory.put(beanName,ClassLoader.initObject(waitInitClassMap.get(beanName)));
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        DIExecute.doDI();
        AopRegister.doRegist();
    }

    private Collection<String> getClassPath(Class clazz, String path) {
        if(path == null || path.equals("")) {
            path = clazz.getPackage().getName().replace(".","\\");
        } else {
            path = path.replace(".", File.separator);
        }
        path = getPathByClass(clazz) + path;
        List<String> fileNmaes = new ArrayList<>();

        getClassNames(new File(path), fileNmaes);
        return fileNmaes;
    }

    private void getClassNames(File file, List<String> resultNames) {
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(File f : files) {
                getClassNames(f, resultNames);
            }
        } else {
            resultNames.add(file.getPath());
        }
    }

    private String getPathByClass(Class clazz) {
        String classPath = clazz.getResource("/").getPath();
        return classPath;
    }
}
