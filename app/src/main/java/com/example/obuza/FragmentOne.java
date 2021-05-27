package com.example.obuza;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import static com.example.obuza.FragmentTwo.fragmentOne;
import static com.example.obuza.FragmentTwo.handler;
import static com.example.obuza.FragmentTwo.seekBar;


public class FragmentOne extends Fragment {
    ImageButton mButton1;
    ImageButton mButton2;
    ImageButton mButton3;
    ImageButton mButton4;
    ImageButton mButton5;
    public static MediaPlayer mediaPlayer = new MediaPlayer();;
    String audioUrl;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View inflatedView = inflater.inflate(R.layout.fragment_one, container, false);
        mButton1 = (ImageButton) inflatedView.findViewById(R.id.imageButton1);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Нажата кнопка 'OK'",Toast.LENGTH_SHORT).show();

                audioUrl = "https://dnl.megapesni.com/get/online/9tFvDfYYsDwYASB126OGsQ/1622092452/7b735859/2017/04/%D0%9E%D0%BB%D1%8C%D0%B3%D0%B0%20%D0%91%D1%83%D0%B7%D0%BE%D0%B2%D0%B0%20-%20%D0%9B%D1%8E%D0%B4%D0%B8%20%D0%9D%D0%B5%20%D0%92%D0%B5%D1%80%D0%B8%D0%BB%D0%B8.mp3";

                try {

                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(audioUrl);
                    mediaPlayer.prepare();

                    mediaPlayer.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
//                    mediaPlayer.setDataSource("https://cdn.mp3xa.me/TOzrhEwW2az9QC74iRIE0g/1621893712/L29ubGluZS9tcDMvMjAxNy8wMS_QntC70YzQs9CwINCR0YPQt9C-0LLQsCAtINCf0YDQuNCy0YvQutCw0Y4ubXAz");

                FragmentTwo.UpdateSeekBar updateSeekBar = new FragmentTwo.UpdateSeekBar();
                handler.post(updateSeekBar);



            }
        });
        mButton2 = (ImageButton) inflatedView.findViewById(R.id.imageButton2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Нажата кнопка 'OK'",Toast.LENGTH_SHORT).show();

                audioUrl = "https://dnl.megapesni.com/get/online/kDQM5AiJhCu3WMjx7IbAhg/1622092116/44a4605d/2018/12/Ольга Бузова - Танцуй Под Бузову.mp3";
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(audioUrl);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
//                    FragmentTwo.UpdateSeekBar updateSeekBar = new FragmentTwo.UpdateSeekBar();
//                    handler.post(updateSeekBar);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FragmentTwo.UpdateSeekBar updateSeekBar = new FragmentTwo.UpdateSeekBar();
                handler.post(updateSeekBar);
//




            }
        });
        mButton3 = (ImageButton) inflatedView.findViewById(R.id.imageButton3);
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                audioUrl = "https://cdn1.sefon.pro/prev/QJJsLVuF4_liHtFzhfLfQw/1622002414/173/%D0%9E%D0%BB%D1%8C%D0%B3%D0%B0%20%D0%91%D1%83%D0%B7%D0%BE%D0%B2%D0%B0%20-%20%D0%94%D0%B0%D0%B2%D0%B0%D0%B9%20%D0%9E%D1%81%D1%82%D0%B0%D0%BD%D0%B5%D0%BC%D1%81%D1%8F%20%D0%94%D0%BE%D0%BC%D0%B0%20%28192kbps%29.mp3";
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(audioUrl);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
//                    FragmentTwo.UpdateSeekBar updateSeekBar = new FragmentTwo.UpdateSeekBar();
//                    handler.post(updateSeekBar);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FragmentTwo.UpdateSeekBar updateSeekBar = new FragmentTwo.UpdateSeekBar();
                handler.post(updateSeekBar);
//




            }
        });
        mButton4 = (ImageButton) inflatedView.findViewById(R.id.imageButton4);
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                audioUrl = "https://cdn5.sefon.pro/prev/_0MLP4SqUx4NKWE4HKX30A/1622002728/209/%D0%9E%D0%BB%D1%8C%D0%B3%D0%B0%20%D0%91%D1%83%D0%B7%D0%BE%D0%B2%D0%B0%20%26%20Dava%20-%20%D0%A1%D0%BD%D0%B5%D0%B6%D0%B8%D0%BD%D0%BA%D0%B8%20%28192kbps%29.mp3";
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(audioUrl);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
//                    FragmentTwo.UpdateSeekBar updateSeekBar = new FragmentTwo.UpdateSeekBar();
//                    handler.post(updateSeekBar);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FragmentTwo.UpdateSeekBar updateSeekBar = new FragmentTwo.UpdateSeekBar();
                handler.post(updateSeekBar);
//




            }
        });
        mButton5 = (ImageButton) inflatedView.findViewById(R.id.imageButton5);
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                audioUrl = "https://cdn2.sefon.pro/prev/GsPwR0iNMkI1jpJyQGkOzg/1622002546/144/%D0%9E%D0%BB%D1%8C%D0%B3%D0%B0%20%D0%91%D1%83%D0%B7%D0%BE%D0%B2%D0%B0%20-%20%D0%9D%D0%B5%20%D0%92%D0%B8%D0%BD%D0%BE%D0%B2%D0%B0%D1%82%D0%B0%20%28192kbps%29.mp3";
                try {
                    mediaPlayer.reset();
                    mediaPlayer.setDataSource(audioUrl);
                    mediaPlayer.prepare();
                    mediaPlayer.start();
//                    FragmentTwo.UpdateSeekBar updateSeekBar = new FragmentTwo.UpdateSeekBar();
//                    handler.post(updateSeekBar);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FragmentTwo.UpdateSeekBar updateSeekBar = new FragmentTwo.UpdateSeekBar();
                handler.post(updateSeekBar);
//




            }
        });
        return inflatedView;
    }

}
