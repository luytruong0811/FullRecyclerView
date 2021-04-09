package com.example.fullrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.badge.BadgeUtils;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private List<Song> mSongs;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public SongAdapter(Context context, List<Song> datas) {
        mContext = context;
        mSongs = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate view from row_item_song.xml
        View itemView = mLayoutInflater.inflate(R.layout.row_item_song, parent, false);
        return new SongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        // Get song in mSong via position
        Song song = mSongs.get(position);

        //bind data to viewholder
        holder.tvCode.setText(song.getCode());
        holder.tvTitle.setText(song.getTitle());
        holder.tvLyric.setText(song.getLyric());
        holder.tvArtist.setText(song.getArtist());
        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(position);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Song song = mSongs.get(position);
                Toast.makeText(mContext, song.getTitle(), Toast.LENGTH_SHORT).show();
            }

        });

        holder.btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Song song=mSongs.get(position);
//                String code = song.getCode();
//                String title = song.getTitle();
//                String lyric = song.getLyric();
//                String artist = song.getArtist();
//                updateItem(position);

            }
        });

    }

    private void deleteItem(int position) {
        mSongs.remove(position);
        notifyDataSetChanged();
    }

    private void updateItem(int position) {
        Song song = new Song("12345", "CÓ CHÀNG TRAI VIẾT LÊN CÂY", "Ngày cô ấy đi theo chân mẹ cha ... ", "Phan Mạnh Quỳnh");
        mSongs.set(position, song);
        notifyItemChanged(position);
    }
    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCode;
        private TextView tvTitle;
        private TextView tvLyric;
        private TextView tvArtist;
        private Button btDelete;
        private Button btUpdate;

        public SongViewHolder(View itemView) {
            super(itemView);
            tvCode = (TextView) itemView.findViewById(R.id.tv_code);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvLyric = (TextView) itemView.findViewById(R.id.tv_lyric);
            tvArtist = (TextView) itemView.findViewById(R.id.tv_artist);
            btDelete = (Button) itemView.findViewById(R.id.bt_Delete);
            btUpdate = (Button) itemView.findViewById(R.id.bt_Update);
        }
    }
}