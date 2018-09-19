package com.charlezz.proxyexample;

import android.support.annotation.NonNull;

public class MainData {

    private String name;
    private Navigator navigator;

    public MainData(String name, @NonNull Navigator navigator){
        this.name = name;
        this.navigator = navigator;
    }

    public String getName() {
        return name;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    interface Navigator{
        void onItemClick(MainData data);
    }


    public void onDataClick(){
        navigator.onItemClick(this);
    }


}
