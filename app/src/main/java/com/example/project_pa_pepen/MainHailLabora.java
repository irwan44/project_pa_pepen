package com.example.project_pa_pepen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainHailLabora extends AppCompatActivity {
    CardView hasil;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hail_labora);

        hasil= findViewById(R.id.hasil);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
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

        hasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainSheetLabora mainSheetLabora = new MainSheetLabora();
                mainSheetLabora.show(getSupportFragmentManager(),"TAG");

            }
        });

    }

}