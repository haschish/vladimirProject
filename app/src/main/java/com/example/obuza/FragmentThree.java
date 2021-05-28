package com.example.obuza;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.obuza.databinding.FragmentThreeBinding;

//import static com.example.obuza.FragmentOne.mediaPlayer;
//import static com.example.obuza.FragmentTwo.fragmentOne;
//import static com.example.obuza.FragmentTwo.handler;

interface OnProgressChange extends SeekBar.OnSeekBarChangeListener {
    @Override
    default void onStartTrackingTouch(SeekBar seekBar){
    };

    @Override
    default void onStopTrackingTouch(SeekBar seekBar){
    };
}


public class FragmentThree extends Fragment {

    static SeekBar seekBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentThreeBinding binding = FragmentThreeBinding.inflate(getLayoutInflater());
        MyModel viewModel = new ViewModelProvider(requireActivity()).get(MyModel.class);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());

        binding.seekBar.setOnSeekBarChangeListener(new OnProgressChange() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {
                if (fromUser) {
                    viewModel.setSongPosition(i);
                }
            }
        });

        return binding.getRoot();

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