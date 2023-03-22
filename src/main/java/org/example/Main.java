package org.example;

import prototype.BeanUtils;
import prototype.Student;
import proxy.api.IPerson;
import proxy.cglibProxy.CglibProxy;
import proxy.impl.Blake;
import proxy.impl.Kris;
import proxy.impl.Liam;
import proxy.proxy.DyProxy;
import proxy.proxy.JDKDynamicProxy;
import proxy.proxy.ProxyObject;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Student s = new Student();
//        s.setAge(11);
//        s.setName("张三");
//        s.setSex(1);
//        Object copy = BeanUtils.copy(s);
//        copy.toString();
//
//        Student sl = new Student();
//
//        BeanUtils.copy(sl, s);
//
//        sl.toString();

//        ProxyObject proxyObject = new ProxyObject(new Liam());
//        proxyObject.sing();
//        DyProxy dyProxy = new DyProxy();
//        dyProxy.execute(new Blake(), Blake.class.getMethod("sing"));
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
        IPerson blake = (IPerson) jdkDynamicProxy.getInstance(new Blake());
        blake.sing();

//        CglibProxy cglibProxy = new CglibProxy();
//        Kris blakes = (Kris) cglibProxy.getInstance(Kris.class);
//        blakes.sing();
    }
}