package com.bayutb123.javacleanarchitecture.ui.screen.home;

import androidx.appcompat.app.AppCompatActivity;

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

@AndroidEntryPoint
public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    @Inject
    SharedPreference sharedPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textView.setText(sharedPreference.getName());
    }

    public void changePref(View view) {
        sharedPreference.setData("Data diupdate lagi");
        binding.textView.setText(sharedPreference.getName());
    }
}