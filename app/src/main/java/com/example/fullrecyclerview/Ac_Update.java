package com.example.fullrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ac_Update extends AppCompatActivity {

    private EditText edtCode, edtTitle, edtLyric, edtArtist;
    private Button btUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac__update);
        getWidget();
        setAction();
    }

    private void setAction() {
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void getWidget() {
        edtCode = findViewById(R.id.edt_code_update);
        edtTitle = findViewById(R.id.edt_title_update);
        edtLyric = findViewById(R.id.edt_lyric_update);
        edtArtist = findViewById(R.id.edt_artist_update);
        btUpdate = findViewById(R.id.bt_updateItem);
    }
}