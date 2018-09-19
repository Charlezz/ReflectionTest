package com.charlezz.proxyexample;

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
        sendPointToEntryToServer();
        Object result = method.invoke(target, objects);

        return result;
    }
    private void sendPointToEntryToServer(){
        // TODO 진입점 클릭정보를 서버로 전송
    }
}
