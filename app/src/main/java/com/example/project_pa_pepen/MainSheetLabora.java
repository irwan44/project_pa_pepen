package com.example.project_pa_pepen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainSheetLabora extends BottomSheetDialogFragment {


    public MainSheetLabora() {
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.swipe_hasil_labora,container,false);
        return view;



    }
    @Override public int getTheme() {
        return R.style.CustomBottomSheetDialog;
    }

}