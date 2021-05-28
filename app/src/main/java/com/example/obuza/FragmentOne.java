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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.obuza.databinding.FragmentOneBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.obuza.FragmentTwo.fragmentOne;
import static com.example.obuza.FragmentTwo.handler;
import static com.example.obuza.FragmentTwo.seekBar;


public class FragmentOne extends Fragment {
    List<Song> list = new ArrayList<Song>();
    public FragmentOne() {
        super(R.layout.fragment_one);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentOneBinding binding = FragmentOneBinding.inflate(getLayoutInflater());
        MyModel viewModel = new ViewModelProvider(requireActivity()).get(MyModel.class);
        viewModel.getStatus().observe(getViewLifecycleOwner(), (status) -> {
            if (status == Status.OK) {
                SongAdapter adapter = new SongAdapter(viewModel);
                binding.allSongsRecyclerView.setAdapter(adapter);
            }
        });
        binding.setViewModel(viewModel);

        return binding.getRoot();
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        list.add(new Song("Люди не верили"));
//        RecyclerView allSongs = view.findViewById(R.id.allSongsRecyclerView);
//        SongAdapter adapter = new SongAdapter(list);
//        allSongs.setAdapter(adapter);
//    }


}
