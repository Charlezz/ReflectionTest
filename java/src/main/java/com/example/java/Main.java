package com.example.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class proxyClass = Proxy.getProxyClass(
                IFoo.class.getClassLoader(),
                new Class[]{IFoo.class,IFoo2.class}
        );
        Constructor constructor = proxyClass.getConstructor(
                InvocationHandler.class
        );

        Foo foo = new Foo();
        InvocationHandler handler = new FooHandler(foo);
        Object object = constructor.newInstance(new Object[]{handler});
        IFoo proxy = (IFoo) object;
        proxy.showMessage();

        if(proxy instanceof IFoo){
            System.out.println("proxy is child of IFoo");
        }

        if(proxy instanceof IFoo2){
            System.out.println("proxy is child of IFoo2");
        }

    }
}
