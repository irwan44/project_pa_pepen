package com.example.project_pa_pepen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);


    }

    public void Login (View view) {
        Intent i = new Intent(MainLogin.this, MainActivity.class);
        startActivity(i);
    }

    public void Register (View view) {
        Intent i = new Intent(MainLogin.this, MainRegister.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
    }
}