package com.example.obuza;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
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
    MediaPlayer mediaPlayer = new MediaPlayer();
    CountDownTimer timer;

    public MyModel() {
        loadSongs();
        timer = new CountDownTimer(7*24*3600*1000, 200) {
            @Override
            public void onTick(long l) {
                updateSongPosition();
            }

            @Override
            public void onFinish() {
            }
        };
    }

    private MutableLiveData<List<Song>> list = new MutableLiveData<List<Song>>();
    public LiveData<List<Song>> getList() {
        return list;
    }

    private MutableLiveData<Status> status = new MutableLiveData<>();
    public LiveData<Status> getStatus() {
        return status;
    }

    private MutableLiveData<Song> currentSong = new MutableLiveData<>();
    public LiveData<Song> getCurrentSong() {
        return currentSong;
    }

    private MutableLiveData<Boolean> playing = new MutableLiveData<>(false);
    public LiveData<Boolean> getPlaying() {
        return playing;
    }

    private MutableLiveData<Integer> songDuration = new MutableLiveData<>(0);
    public LiveData<Integer> getSongDuration() {
        return songDuration;
    }

    private MutableLiveData<Integer> songPosition = new MutableLiveData<>(0);
    public LiveData<Integer> getSongPosition() {
        return songPosition;
    }


    public void playSong(Song song) {
        currentSong.setValue(song);

        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(song.songLink);
            mediaPlayer.prepare();
            songDuration.setValue(mediaPlayer.getDuration());
            mediaPlayer.start();
            timer.start();
            playing.setValue(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        mediaPlayer.start();
        timer.start();
        playing.setValue(true);
    }

    public void pause() {
        mediaPlayer.pause();
        timer.cancel();
        playing.setValue(false);
    }

    public void setSongPosition(Integer position) {
        mediaPlayer.seekTo(position);
        songPosition.setValue(position);
    }

    private void updateSongPosition() {
        songPosition.setValue(mediaPlayer.getCurrentPosition());

    }


    private void loadSongs() {
        status.setValue(Status.LOADING);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://obuza.deno.dev/")
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
