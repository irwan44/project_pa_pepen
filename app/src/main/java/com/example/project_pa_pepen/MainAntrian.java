package com.example.project_pa_pepen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

public class MainAntrian extends AppCompatActivity {

    CardView btn_antrian;

    //Dialog Confirm
    AlertDialog.Builder dial_builder, dial_builder2, dial_builder3 ;
    AlertDialog dial_anterian, dial_ya, dial_belum;
    LayoutInflater inflater;
    View dialogView, dialogView2, dialogView3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_antrian);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

            //menerapkan tool bar sesuai id toolbar | ToolBarAtas adalah variabel buatan sndiri
            Toolbar LabToolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(LabToolbar);
//        LabToolbar.setLogoDescription(getResources().getString(R.string.app_name));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            LabToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });



        }

        btn_antrian     = findViewById(R.id.btn_antrian);



        //Dialog ask login
        dial_builder = new AlertDialog.Builder(MainAntrian.this,R.style.CustomAlertDialog);
        dial_builder2 = new AlertDialog.Builder(MainAntrian.this,R.style.CustomAlertDialog);
        dial_builder3 = new AlertDialog.Builder(MainAntrian.this,R.style.CustomAlertDialog);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ViewGroup viewGroup = findViewById(com.google.android.material.R.id.content);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_ask_informasi, viewGroup, false);
        dialogView2 = inflater.inflate(R.layout.dialog_ask_form_terdaftar, viewGroup, false);
        dialogView3 = inflater.inflate(R.layout.dialog_ask_informasi_antrian, viewGroup, false);
        Button btn_act_tidak = dialogView.findViewById(R.id.btn_belumpernah);
        Button btn_act_ok = dialogView3.findViewById(R.id.btn_ok);
        Button btn_act_ya = dialogView.findViewById(R.id.btn_ya);
        Button btn_act_cancel = dialogView.findViewById(R.id.btn_cancel);
        Button btn_act_cancel2 = dialogView2.findViewById(R.id.btn_cancel);
        Button btn_act_cancel3 = dialogView3.findViewById(R.id.btn_cancel);
        dial_builder.setView(dialogView);
        dial_builder2.setView(dialogView2);
        dial_builder3.setView(dialogView3);
        dial_anterian = dial_builder.create();
        dial_anterian.setCancelable(false);
        dial_anterian.setCanceledOnTouchOutside(false);
        dial_ya = dial_builder2.create();
        dial_ya.setCancelable(false);
        dial_ya.setCanceledOnTouchOutside(false);
        dial_belum = dial_builder3.create();
        dial_belum.setCancelable(false);
        dial_belum.setCanceledOnTouchOutside(false);

        //setOnclick listener

        btn_antrian.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dial_anterian.show();
            }

        });

        btn_act_tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_belum.show();


            }
        });

        btn_act_ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_ya.show();


            }
        });
        btn_act_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_anterian.cancel();
            }
        });
        btn_act_cancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_ya.dismiss();
                isFinishing();
            }
        });
        btn_act_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_belum.dismiss();
                isFinishing();
            }
        }); btn_act_cancel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_belum.dismiss();
                isFinishing();
            }
        });



    }
}