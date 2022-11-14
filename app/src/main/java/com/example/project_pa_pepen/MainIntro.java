package com.example.project_pa_pepen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainIntro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intro);
    }
    public void login2 (View view) {
        Intent i = new Intent(MainIntro.this, MainLogin.class);
        startActivity(i);
    }
    public void register2 (View view) {
        Intent i = new Intent(MainIntro.this, MainRegister.class);
        startActivity(i);
    }
}