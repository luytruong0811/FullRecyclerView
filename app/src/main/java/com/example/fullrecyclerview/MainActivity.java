package com.example.fullrecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private RecyclerView rvSongs;
    private SongAdapter mSongAdapter;
    private List<Song> mSongs;
    private Button btAddItem;
    private Button btClear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvSongs = (RecyclerView)findViewById(R.id.rv_songs);
        // Create song data
        mSongs = new ArrayList<>();
        mSongs.add(new Song("60696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu Là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new Song("60701", "NGỐC", "..iết...", "Khắc Việt"));
        mSongs.add(new Song("60650", "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau Cô yêu thương", "Thiên Dũng"));
        mSongs.add(new Song("60610", "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập tràng bao", "Duy Cường"));
        mSongs.add(new Song("60656", "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay Nước mắt em", "Phạm Mạnh Quỳnh"));
        mSongs.add(new Song("60685", "MỞ", "Anh mơ gặp em anh mơ được ôm anh mơ được gần", "Trịnh Thăng Bình"));
        mSongs.add(new Song("60752", "TÌNH YÊU CHẮP VÁ", "Muốn đi xa nơi yêu thương mình từng có Để không nghe", "Mr. Siro"));
        mSongs.add(new Song("60608", "CHỜ NGÀY MƯA TAN", "1 ngày mưa và em khuất xa nơi anh bóng dáng cứ", "Trung Đức"));
        mSongs.add(new Song("60603", "CÂU HỎI EM CHƯA TRẢ LỜI", "Cần nơi em 1 lời giải thích thật lòng Đừng lặng im", "Yuki Huy Nam"));
        mSongs.add(new Song("60720", "QUA ĐI LẶNG LẼ", "Đôi khi đến với nhau yêu thương chẳng được lâu nhưng khi", "Phan Mạnh Quỳnh"));
        mSongs.add(new Song("60856", "QUÊN ANH LÀ ĐIỀU EM KHÔNG THỂ - REMIX", "Cần thêm bao lâu để em quên đi niềm đâu Cần thêm", "Thiện Ngôn"));
        mSongAdapter = new SongAdapter(this,  mSongs);
        rvSongs.setAdapter(mSongAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvSongs.addItemDecoration(itemDecoration);
        ItemTouchHelper touchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                mSongs.remove(position);
                mSongAdapter.notifyDataSetChanged();
            }
        });
        touchHelper.attachToRecyclerView(rvSongs);
        openActivityToAdd();
    }

    private void openActivityToAdd() {
        btAddItem=findViewById(R.id.bt_addItem);
        try {
            btAddItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, Ac_Add.class);
                    startActivityForResult(intent, 308);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==308) {
            if (resultCode==Ac_Add.RESULT_OK) {
                Song song = (Song) data.getSerializableExtra("TempKey");
                if(song!=null){
                    mSongs.add(0,song);
                    mSongAdapter.notifyDataSetChanged();
                }
            }
            else{
                Toast.makeText(this, "resultCode is incorrect", Toast.LENGTH_SHORT);
            }
        }
        else{
            Toast.makeText(this, "requestCode is incorrect", Toast.LENGTH_SHORT);
        }
    }


}