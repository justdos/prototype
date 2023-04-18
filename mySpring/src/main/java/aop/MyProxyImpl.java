package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxyImpl<T> implements InvocationHandler {

    private Method aroundMethod;

    private T o;

//    public MyProxyImpl(T target, Method aroundMethod) {
//        this.target = target;
////        this.aroundMethod = aroundMethod;
//    }

//    public MyProxyImpl(T target) {
//        this.target = target;
//    }
    public T getInstance(T t, Method aroundMethod) {
        this.o = t;
        this.aroundMethod = aroundMethod;
        Class<?> clazz = o.getClass();
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyProceedingJoinPoint myProceedingJoinPoint = new MyProceedingJoinPoint();
        myProceedingJoinPoint.setArgs(args);
        myProceedingJoinPoint.setMethod(method);
        myProceedingJoinPoint.setObject(o);
        method.setAccessible(true);
        aroundMethod.setAccessible(true);
        Object aspectClass = aroundMethod.getDeclaringClass().newInstance();
        return aroundMethod.invoke(aspectClass, myProceedingJoinPoint);
    }
}
