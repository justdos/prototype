package proxy.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DyProxy<T> {

//    T o;

    public void execute(T o,Method method, Object... params) throws InvocationTargetException, IllegalAccessException {
        Class<?> aClass = o.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method m:declaredMethods) {
            if(m.equals(method)) {
                System.out.println("prepare to invoke method ");
                m.invoke(o,params);
                System.out.println("fininsh invoke");
            }
        }
    }

}
