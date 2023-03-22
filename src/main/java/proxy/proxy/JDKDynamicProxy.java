package proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxy<T> implements InvocationHandler {

    private T o;

    public T getInstance(T t) {
       this.o = t;
       Class<?> clazz = o.getClass();
       return (T)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        //此处也可做权限校验，不一定需要调用原方法
        Object result = method.invoke(this.o, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("prepare to sing");
    }

    private void after() {
        System.out.println("finish singing");
    }
}
