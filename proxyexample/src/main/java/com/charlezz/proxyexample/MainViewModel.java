package com.charlezz.proxyexample;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel{

    private Navigator navigator;

    private List<MainData> items;

    public List<MainData> getItems(){
        return items;
    }

    public MainViewModel(Navigator navigator){
        this.navigator = navigator;
        items = new ArrayList<>();

        items.add(new MainData("Charles", navigator));
        items.add(new MainData("Chris",navigator));
        items.add(new MainData("Nick",navigator));
        items.add(new MainData("Runa",navigator));
        items.add(new MainData("Ray",navigator));
        items.add(new MainData("Sam",navigator));
        items.add(new MainData("James",navigator));
        items.add(new MainData("Andy",navigator));
        items.add(new MainData("Chloe",navigator));
        items.add(new MainData("Jay",navigator));
        items.add(new MainData("Jean",navigator));
        items.add(new MainData("Jack",navigator));

    }

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, List<MainData> items){
        if(items!=null){
            MainAdapter adapter = (MainAdapter) recyclerView.getAdapter();
            adapter.setItems(items);
        }

    }

    public interface Navigator extends MainData.Navigator{

    }
}
