package com.charlezz.dynamicproxy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}


//class MainActivity : AppCompatActivity() {
//        val TAG = MainActivity::class.java.simpleName
//        override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val multiplier:Multiplier = MultiplierImpl()
//        val multiplierProxy = Proxy.newProxyInstance(javaClass.classLoader, arrayOf(Multiplier::class.java), ProxyHandler(multiplier)) as Multiplier
//
//        val result = multiplierProxy.multiply(6)
//        Log.e(TAG,"result = $result")
//
//        //Simple Example
////        ReflectionTest().simpleExample()
//        val r = ReflectionTest()
//        r.invokePrivate()
//
//        }
//        }
//
//class ProxyHandler(val target:Any): InvocationHandler{
//        override fun invoke(proxy: Any?, method: Method?, args: Array<Any>): Any? {
//        Log.e(TAG,"before invoking")
//        val result = method?.invoke(target, *args)
//        Log.e(TAG,"after invoking")
//        return result
//        }
//
//        val TAG = ProxyHandler::class.java.simpleName
//
//
//        }
//class MultiplierImpl : Multiplier{
//        override fun multiply(x: Int) : Int = x*2
//
//        }
//
//interface Multiplier {
//    fun multiply(x:Int):Int
//}