package com.charlezz.proxyexample;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.charlezz.proxyexample.databinding.ActivityMainBinding;
import com.charlezz.proxyexample.di.ActivityScope;

import java.lang.reflect.Proxy;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {
    @ActivityScope
    @Provides
    static ActivityMainBinding provideBinding(MainActivity activity){
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }

    @ActivityScope
    @Provides
    static MainAdapter provideAdapter(){
        return new MainAdapter();
    }

    @ActivityScope
    @Provides
    static MainViewModel provideViewModel(final MainActivity activity, final MainViewModel.Navigator navigator){
        return ViewModelProviders.of(activity, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(navigator);
            }
        }).get(MainViewModel.class);
    }

    @ActivityScope
    @Provides
    static MainInvocationHandler provideInvocationHandler ( MainActivity activity){
        return new MainInvocationHandler(activity);
    }

    @ActivityScope
    @Provides
    static MainViewModel.Navigator provideNavigator(MainInvocationHandler invocationHandler){
        return (MainViewModel.Navigator) Proxy.newProxyInstance(
                invocationHandler.getClass().getClassLoader(),//아무 클래스 로더나 넣어줌
                new Class[]{MainViewModel.Navigator.class},
                invocationHandler);
    }

    @ActivityScope
    @Provides
    static Toast provideToast(MainActivity activity){
        return Toast.makeText(activity, "", Toast.LENGTH_SHORT);
    }

}
