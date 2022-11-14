package com.example.project_pa_pepen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainRegisterLengkap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register_lengkap);
    }
    @Override
    public void onBackPressed() {
    }
    public void simpan (View view) {
        Intent i = new Intent(MainRegisterLengkap.this, MainActivity.class);
        startActivity(i);
    }

}