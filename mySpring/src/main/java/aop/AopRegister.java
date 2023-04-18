package aop;

import IoC.BeanFactory;
import annotion.MyAroundAOP;
import annotion.MyAspect;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class AopRegister {
    public static void doRegist() throws Exception{
        Map<String,Object> beanMap =  BeanFactory.beanMap;
        if(beanMap.isEmpty()) {
            return;
        }
        Method aroudMethod = null;
        for(Object bean : beanMap.values()) {
            Class<?> clazz = bean.getClass();
            MyAspect annotation = clazz.getAnnotation(MyAspect.class);
            if(annotation == null ) {
                continue;
            }
//            Method[] methods = clazz.getMethods();
            Method[] methods = clazz.getDeclaredMethods();
            for(Method m:methods) {
                MyAroundAOP myAroundAOP = m.getAnnotation(MyAroundAOP.class);
                if(myAroundAOP == null) {
                    continue;
                }
                if(aroudMethod != null) {
                    throw new Exception("more than one around method declare!");
                }
                aroudMethod = m;
            }
        }
        if(aroudMethod != null) {
            for(String beanName:beanMap.keySet()) {
                Object bean = beanMap.get(beanName);
                Class<?>[] interfaces = bean.getClass().getInterfaces();
                if(interfaces == null || interfaces.length == 0) {
                    continue;
                }
                Object instance = new MyProxyImpl().getInstance(bean, aroudMethod);
                beanMap.put(beanName,instance);
//                Object o = Proxy.newProxyInstance(bean.getClass().getClassLoader(), interfaces, new MyProxyImpl<>(bean));
//                beanMap.put(beanName, o);
            }
        }
    }

    private void invokeAopMethod() {

    }
}
