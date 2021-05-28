package com.example.obuza;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

interface SongService {
    @GET("/")
    Call<List<Song>> getAll();
}

enum Status {
    LOADING,
    FAIL,
    OK
}

public class MyModel extends ViewModel {

    public MyModel() {
        loadSongs();
    }

    private MutableLiveData<List<Song>> list = new MutableLiveData<List<Song>>();
    public LiveData<List<Song>> getList() {
        return list;
    }

    private MutableLiveData<Status> status = new MutableLiveData<>();
    public LiveData<Status> getStatus() {
        return status;
    }


    private void loadSongs() {
        status.setValue(Status.LOADING);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://obuza-api.deno.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SongService api = retrofit.create((SongService.class));
        Call<List<Song>> call = api.getAll();
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                list.setValue(response.body());
                status.setValue(Status.OK);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {
                status.setValue(Status.FAIL);
            }
        });
    }
}
