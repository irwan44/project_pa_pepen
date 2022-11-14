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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainJadwalOlnline extends AppCompatActivity {

    TextView txthasil;
    RadioGroup Radiogroup;

    Spinner spinner;
    String nama;
    TextView tv_siswa;
    Button btn_submit;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jadwal_olnline2);

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


        spinner = (Spinner) findViewById(R.id.sp_name_2);
        tv_siswa = (TextView) findViewById(R.id.tv_siswa);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        Radiogroup =  findViewById(R.id.radioGroup);
        txthasil = findViewById(R.id.texthasil);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }



        Radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
                    public void onCheckedChanged ( RadioGroup group, int checkedId){
                RadioButton rb = findViewById(checkedId);
                if(rb!=null)
                    txthasil.setText(rb.getText());

        }
    });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nama = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nama.equals("")){
                    tv_siswa.setText(nama);
                    Toast.makeText(MainJadwalOlnline.this, "Anda Memilih "+nama, Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    public void lihatdokter (View view) {
        Intent i = new Intent(MainJadwalOlnline.this, MainJadwalOnlineSelect.class);
        startActivity(i);
    }
}