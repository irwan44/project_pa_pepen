package com.example.project_pa_pepen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    CardView btn_pemeriksaan, btn_summary;

    //Dialog Confirm
    AlertDialog.Builder dial_builder;
    AlertDialog dial_summary;
    LayoutInflater inflater;
    View dialogView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_pemeriksaan = findViewById(R.id.btn_hasil_pemeriksaan);
        btn_summary = findViewById(R.id.btn_summary);


            btn_pemeriksaan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainSheetMenu1 mainSheetMenu1 = new MainSheetMenu1();
                    mainSheetMenu1.show(getSupportFragmentManager(),"TAG");

                }
            });

        //Dialog ask login
        dial_builder = new AlertDialog.Builder(MainActivity.this, R.style.CustomAlertDialog);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ViewGroup viewGroup = findViewById(com.google.android.material.R.id.content);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_ask_form_terdaftar, viewGroup, false);
        Button btn_act_cancel = dialogView.findViewById(R.id.btn_cancel);
        dial_builder.setView(dialogView);
        dial_summary = dial_builder.create();
        dial_summary.setCancelable(false);
        //setOnclick listener

        btn_summary.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dial_summary.show();
            }
        });


        btn_act_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_summary.dismiss();
            }
        });


    }
    public void Pendaftran (View view) {
        Intent i = new Intent(MainActivity.this, MainPendafOnline.class);
        startActivity(i);
    }
    public void infokamar (View view) {
        Intent i = new Intent(MainActivity.this, MainInforKamar.class);
        startActivity(i);
    }
    public void jadwalonline (View view) {
        Intent i = new Intent(MainActivity.this, MainJadwalOlnline.class);
        startActivity(i);
    }

    public void labo (View view) {
        Intent i = new Intent(MainActivity.this, MainHailLabora.class);
        startActivity(i);
    }
    public void rado (View view) {
        Intent i = new Intent(MainActivity.this, MainHasilRadiologi.class);
        startActivity(i);
    }
    public void info (View view) {
        Intent i = new Intent(MainActivity.this, MainInfo.class);
        startActivity(i);
    }
    public void antrian (View view) {
        Intent i = new Intent(MainActivity.this, MainAntrian.class);
        startActivity(i);
    }
    public void profile (View view) {
        Intent i = new Intent(MainActivity.this, MainProfile.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
    }

}

