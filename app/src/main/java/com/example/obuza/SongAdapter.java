package com.example.obuza;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.Holder> {
    private List<Song> list;
    public SongAdapter(List<Song> list) {
        this.list = list;
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Song song = list.get(position);
        holder.title.setText(song.name);
        holder.singer.setText(song.songLink);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView title;
        TextView singer;
        public Holder(View v) {
            super(v);
            title = v.findViewById(R.id.titleTextView);
            singer = v.findViewById(R.id.singerTextView);
        }
    }
}
