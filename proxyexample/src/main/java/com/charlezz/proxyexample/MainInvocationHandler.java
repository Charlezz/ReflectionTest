package com.charlezz.proxyexample;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MainInvocationHandler implements InvocationHandler {
    public static final String TAG = MainInvocationHandler.class.getSimpleName();

    private Object target;
    public MainInvocationHandler(MainActivity activity){
        target = activity;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Log.e(TAG,"invoke 하기 전");
        Object result = method.invoke(target, objects);
        Log.e(TAG,"invoke 한 후");
        return result;
    }
}
