package com.example.project_pa_pepen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainSwiper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swipe_hasil_pemeriksaan);
    }

    public void labo (View view) {
        Intent i = new Intent(MainSwiper.this, MainHailLabora.class);
        startActivity(i);
    }
}