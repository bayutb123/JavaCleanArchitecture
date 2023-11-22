package com.bayutb123.javacleanarchitecture.ui.screen.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.bayutb123.javacleanarchitecture.R;
import com.bayutb123.javacleanarchitecture.data.local.SharedPreference;
import com.bayutb123.javacleanarchitecture.databinding.ActivityHomeBinding;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
@SuppressLint("SetTextI18n")

@AndroidEntryPoint
public class HomeActivity extends AppCompatActivity {

    @Inject
    SharedPreference sharedPreference;
    ActivityHomeBinding binding;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        i = sharedPreference.getName();
        initUI();
    }

    private void initUI() {
        binding.textView.setText("Total = " + sharedPreference.getName());
    }

    private void refreshUI() {
        binding.textView.setText("Total = " + sharedPreference.getName());
    }

    public void changePref(View view) {
        sharedPreference.setData(i + 1);
        i = sharedPreference.getName();
        refreshUI();
    }
}