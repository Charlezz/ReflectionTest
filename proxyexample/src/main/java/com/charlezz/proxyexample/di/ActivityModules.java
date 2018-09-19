package com.charlezz.proxyexample.di;

import com.charlezz.proxyexample.MainActivity;
import com.charlezz.proxyexample.MainModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModules {
    @ActivityScope
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity mainActivity();
}
