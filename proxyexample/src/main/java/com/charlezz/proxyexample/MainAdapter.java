package com.charlezz.proxyexample;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.charlezz.proxyexample.databinding.ViewTitleBinding;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<MainData> items = null;


    public void setItems(List<MainData> items){
        this.items = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewTitleBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),R.layout.view_title, viewGroup, false);
        return new MainViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        mainViewHolder.binding.setData(items.get(i));
        mainViewHolder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items==null? 0 : items.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder{

        ViewTitleBinding binding;

        public MainViewHolder(@NonNull ViewTitleBinding binding ) {
            super(binding.getRoot());
            this.binding =binding;
        }
    }
}
