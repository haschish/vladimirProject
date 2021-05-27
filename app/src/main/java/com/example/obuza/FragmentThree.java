package com.example.obuza;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

//import static com.example.obuza.FragmentOne.mediaPlayer;
//import static com.example.obuza.FragmentTwo.fragmentOne;
//import static com.example.obuza.FragmentTwo.handler;


public class FragmentThree extends Fragment {

    static SeekBar seekBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_three, container, false);
//        seekBar = (SeekBar) inflatedView.findViewById(R.id.seekBar);
//        seekBar.setMax(mediaPlayer.getDuration());
//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser) {
//                    fragmentOne.mediaPlayer.seekTo(progress);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
        return inflatedView;
    }
//    public static class UpdateSeekBar implements Runnable {
//
//        @Override
//        public void run() {
//            // если убрать условие, то приложение вылетает, но если будет с условие, то  seekbar не передвигается ('void android.widget.SeekBar.setProgress(int)' on a null object reference)
//                seekBar.setProgress(mediaPlayer.getCurrentPosition());
//
//                handler.postDelayed(this, 100);
//
//        }
//    }
}