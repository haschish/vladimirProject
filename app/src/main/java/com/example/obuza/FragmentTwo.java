package com.example.obuza;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

import static com.example.obuza.FragmentOne.mediaPlayer;


public class FragmentTwo extends Fragment {
    ImageButton button;
    ImageButton button3, button4;
    static FragmentOne fragmentOne;
    static SeekBar seekBar;
    static Handler handler = new Handler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_two, container, false);
        seekBar = (SeekBar) inflatedView.findViewById(R.id.seekBar);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    fragmentOne.mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button = (ImageButton) inflatedView.findViewById(R.id.imageButton);
        button3 = (ImageButton) inflatedView.findViewById(R.id.imageButton3);
        button4 = (ImageButton) inflatedView.findViewById(R.id.imageButton4);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(),"Нажата кнопка 'OK'",Toast.LENGTH_SHORT).show();
//
//
//
//                Log.i("datasouceee", String.valueOf(mediaPlayer.getDuration()));
//                Log.i("datasouceeee", String.valueOf(mediaPlayer.getCurrentPosition()));
//
//            }
//        });
            button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();

            }
        });
            button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

            }
        });
        return inflatedView;
    }
    public static class UpdateSeekBar implements Runnable {

        @Override
        public void run() {
            if (mediaPlayer.getCurrentPosition() > 1) { // если убрать условие, то приложение вылетает, но если будет с условие, то  seekbar не передвигается ('void android.widget.SeekBar.setProgress(int)' on a null object reference)
                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                handler.postDelayed(this, 100);
            }
        }
    }
}