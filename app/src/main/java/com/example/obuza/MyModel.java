package com.example.obuza;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class MyModel extends ViewModel {

    private MutableLiveData<List<Song>> list = new MutableLiveData<List<Song>>();
    public LiveData<List<Song>> getList() {
        return list;
    }
}
