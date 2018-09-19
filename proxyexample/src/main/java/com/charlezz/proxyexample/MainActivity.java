package com.charlezz.proxyexample;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.charlezz.proxyexample.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainViewModel.Navigator{

    public static final String TAG = MainActivity.class.getSimpleName();
    @Inject
    ActivityMainBinding binding;

    @Inject
    MainAdapter adapter;

    @Inject
    MainViewModel viewModel;

    @Inject
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.setLifecycleOwner(this);
        binding.recyclerView.setAdapter(adapter);
        binding.setViewModel(viewModel);
    }

    @Override
    public void onItemClick(MainData data) {
        Log.e(TAG,"onItemClick:"+data.getName());
        toast.setText(data.getName());
        toast.show();
    }
}
