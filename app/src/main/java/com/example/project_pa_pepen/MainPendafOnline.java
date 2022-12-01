package com.example.project_pa_pepen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainPendafOnline extends AppCompatActivity {

    ConstraintLayout btn_bpjs;

    //Dialog Confirm
    AlertDialog.Builder dial_builder, dial_builder2;
    AlertDialog dial_bpjs, dial_cari;
    LayoutInflater inflater;
    View dialogView, dialogView2;

    BottomSheetBehavior sheetBehavior;
    BottomSheetDialog sheetDialog;
    View  sheetView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pendaf_online);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        btn_bpjs      = findViewById(R.id.btn_bpjs);

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

        //Dialog ask login
        dial_builder = new AlertDialog.Builder(MainPendafOnline.this,R.style.CustomAlertDialog);
        dial_builder2 = new AlertDialog.Builder(MainPendafOnline.this,R.style.CustomAlertDialog);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ViewGroup viewGroup = findViewById(com.google.android.material.R.id.content);
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_ask_informasi, viewGroup, false);
        dialogView2 = inflater.inflate(R.layout.dialog_ask_form_terdaftar, viewGroup, false);
        Button btn_act_tidak = dialogView.findViewById(R.id.btn_belumpernah);
        Button btn_act_ya = dialogView.findViewById(R.id.btn_ya);
        Button btn_act_cancel = dialogView.findViewById(R.id.btn_cancel);
        Button btn_act_cancel2 = dialogView2.findViewById(R.id.btn_cancel);
        dial_builder.setView(dialogView);
        dial_builder2.setView(dialogView2);
        dial_bpjs = dial_builder.create();
        dial_bpjs.setCancelable(false);
        dial_bpjs.setCanceledOnTouchOutside(false);
        dial_cari = dial_builder2.create();
        dial_cari.setCancelable(false);
        dial_cari.setCanceledOnTouchOutside(false);
        //setOnclick listener

        btn_bpjs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dial_bpjs.show();
            }

        });

        btn_act_tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent i = new Intent(MainPendafOnline.this, MainIdentitasPasien.class);
                startActivity(i);

            }

        });

        btn_act_ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_cari.show();
                dial_bpjs.dismiss();


            }
        });
        btn_act_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_bpjs.cancel();
            }
        });
        btn_act_cancel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial_cari.dismiss();
                isFinishing();
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == event.getKeyCode()) {

            finish();
            return true;

        }
        return super.onKeyDown(keyCode, event);
    }

}