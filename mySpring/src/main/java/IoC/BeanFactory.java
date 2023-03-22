package IoC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

    public static Map<String,Object> beanMap = new HashMap<>();

    //需要Bean的时候优先从该List获取
    public static List<Object> initedBeanList = new ArrayList<>();

    //循环依赖类
    public static List<Object> cycleBeanList = new ArrayList<>();
    public static Object getBean(String beanName) {
        return beanMap.get(beanName);
    }

    public static Object getBean(Class clazz) {
        for(Object o : beanMap.values()) {
            if(clazz.equals(o.getClass())) {
                return o;
            }
        }
        return null;
    }

    public static void put(String beanName,Object bean) {
        beanMap.put(beanName, bean);
        initedBeanList.add(bean);
    }

    public static Object getInitedClass(Class clazz) {
        for(Object initBean:initedBeanList) {
            if(clazz.equals(initBean.getClass())) {
                return initBean;
            }
        }
        return null;
    }

}
