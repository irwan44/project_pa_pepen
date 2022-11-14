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

public class MainDetailAkun extends AppCompatActivity {

    CardView btn_lanjutkan;

    //Dialog Confirm
    AlertDialog.Builder dial_builder;
    AlertDialog dial_logout;
    LayoutInflater inflater;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail_akun);

        btn_lanjutkan      = findViewById(R.id.lanjutkan);
        //Dialog ask login
        dial_builder = new AlertDialog.Builder(MainDetailAkun.this,R.style.CustomAlertDialog);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ViewGroup viewGroup = findViewById(com.google.android.material.R.id.content);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_ask_detailakun, viewGroup, false);
        /*Button btn_act_logout = dialogView.findViewById(R.id.btn_tidak);*/
        Button btn_act_ok = dialogView.findViewById(R.id.btn_ok);
        Button btn_act_cancel = dialogView.findViewById(R.id.btn_cancel);
        dial_builder.setView(dialogView);
        dial_logout = dial_builder.create();
        dial_logout.setCancelable(false);
        //setOnclick listener
        btn_lanjutkan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dial_logout.show();
            }
        });

       /* btn_act_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent i = new Intent(MainRegister.this, MainDetailAkun.class);
                startActivity(i);

            }

        });*/
        btn_act_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent i = new Intent(MainDetailAkun.this, MainRegisterLengkap.class);
                startActivity(i);

            }
        });
        btn_act_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_logout.dismiss();
            }
        });

    }
    public void kembali (View view) {
        Intent i = new Intent(MainDetailAkun.this, MainRegister.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
    }
}