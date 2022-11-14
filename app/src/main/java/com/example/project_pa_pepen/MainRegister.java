package com.example.project_pa_pepen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class MainRegister extends AppCompatActivity {

    CardView btn_register;

    //Dialog Confirm
    AlertDialog.Builder dial_builder;
    AlertDialog dial_regis;
    LayoutInflater inflater;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);

        btn_register      = findViewById(R.id.btn_register);

        //Dialog ask login
        dial_builder = new AlertDialog.Builder(MainRegister.this,R.style.CustomAlertDialog);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ViewGroup viewGroup = findViewById(com.google.android.material.R.id.content);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_ask_register, viewGroup, false);
        Button btn_act_tidak = dialogView.findViewById(R.id.btn_tidak);
        Button btn_act_ya = dialogView.findViewById(R.id.btn_ya);
        Button btn_act_cancel = dialogView.findViewById(R.id.btn_cancel);
        dial_builder.setView(dialogView);
        dial_regis = dial_builder.create();
        dial_regis.setCancelable(false);
        //setOnclick listener

        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dial_regis.show();
            }
        });

        btn_act_tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent i = new Intent(MainRegister.this, MainDetailAkun.class);
                startActivity(i);

            }

        });
        btn_act_ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent i = new Intent(MainRegister.this, MainActivity.class);
                startActivity(i);

            }
        });
        btn_act_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_regis.dismiss();
            }
        });

    }



    public void Login (View view) {
        Intent i = new Intent(MainRegister.this, MainLogin.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
    }
}