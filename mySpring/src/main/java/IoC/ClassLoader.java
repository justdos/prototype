package IoC;

import com.google.common.base.Defaults;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ClassLoader {

    private static List<Object> cycleBeanList = new ArrayList<>();

    //解决两个带参构造类有依赖关系场景，因此需要排序
    //todo 解决循环依赖问题
    public static Object initObject(Class clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        boolean reBuild = false;
        Object initedClass = null;
        if (BeanFactory.getInitedClass(clazz) != null ) {
            initedClass = BeanFactory.getInitedClass(clazz);
            if(!BeanFactory.cycleBeanList.contains(clazz)) {
                return initedClass;
            } else {
                //参数变，但class对象本身不能重新构造
                //todo 手动循环所有参数 碰到null的与initedBeanList进行对比再注入。
            }
        }
        if(!BeanFactory.cycleBeanList.contains(clazz)) {
            if (cycleBeanList.contains(clazz)) {
                //说明循环依赖了
                return null;
            } else {
                cycleBeanList.add(clazz);
            }
        }
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            Class[] parameterTypes = c.getParameterTypes();
            Object[] params = new Object[parameterTypes.length];
            for (int i = 0; i < parameterTypes.length; i++) {
                Class p = parameterTypes[i];
                Object o = null;
                if (p.isPrimitive()) {
                    o = Defaults.defaultValue(p);
                } else if (p.equals(String.class)) {
                    o = "";
                } else {
                    o = initObject(p);
                    if (o == null) {
                        BeanFactory.cycleBeanList.add(clazz);
                    }
                }
                params[i] = o;
            }
            Object o = c.newInstance(params);
            BeanFactory.initedBeanList.add(o);
            return o;
        }
        return null;
    }
}
