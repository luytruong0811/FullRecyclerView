package com.example.fullrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ac_Add extends AppCompatActivity {
    private EditText edtCode;
    private EditText edtTitle;
    private EditText edtLyric;
    private EditText edtArtist;
    private Button btAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac__add);
        edtCode = findViewById(R.id.edt_code_add);
        edtTitle = findViewById(R.id.edt_title_add);
        edtLyric = findViewById(R.id.edt_lyric_add);
        edtArtist = findViewById(R.id.edt_artist_add);
        btAdd = findViewById(R.id.bt_add);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = edtCode.getText().toString().trim();
                String title = edtTitle.getText().toString().trim();
                String lyric = edtLyric.getText().toString().trim();
                String artist = edtArtist.getText().toString().trim();
                Song song = new Song(code, title, lyric, artist);
                Intent intent = new Intent();
                intent.putExtra("TempKey", song);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}