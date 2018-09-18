package com.charlezz.dynamicproxy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity{

    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Multiplier multiplier = new Multiplier2x();
        Multiplier multiplierProxy = (Multiplier) Proxy.newProxyInstance(getClassLoader(), new Class[]{Multiplier.class}, new MyProxyHandler(multiplier));
        int result = multiplierProxy.multiply(2,3);
        Log.e(TAG,"result = "+result);
    }
}
