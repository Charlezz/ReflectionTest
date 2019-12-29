package com.example.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class FooHandler implements InvocationHandler {

   private final Foo target;
   public FooHandler(Foo target){
      this.target = target;
   }

   @Override
   public Object invoke(Object proxy, Method method, Object[] args) {
      System.out.println("FooHandler:invoke()");
      target.showMessage();
      return null;
   }
}
