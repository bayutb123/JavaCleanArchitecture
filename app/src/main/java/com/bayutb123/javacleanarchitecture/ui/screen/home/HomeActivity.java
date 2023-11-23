package com.bayutb123.javacleanarchitecture.ui.screen.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bayutb123.javacleanarchitecture.databinding.ActivityHomeBinding;
import com.bayutb123.javacleanarchitecture.domain.model.User;

import java.util.Objects;

import dagger.hilt.android.AndroidEntryPoint;
@SuppressLint("SetTextI18n")

@AndroidEntryPoint
public class HomeActivity extends AppCompatActivity {

    HomeViewModel viewModel;
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.userLiveData().observe(this, this::initUI);
    }

    private void initUI(User user) {
        binding.tvName.setText("Nama = " + user.getUserName());
        binding.tvAge.setText("Umur = " + user.getUserAge());
        Log.d("Test", "Observed");
    }

    public void changePref(View view) {
        String name = Objects.requireNonNull(binding.etName.getText()).toString();
        String _age = Objects.requireNonNull(binding.etAge.getText()).toString();
        if (!_age.isEmpty()) {
            int age = Integer.parseInt(_age);
            User newUser = new User(name, age);
            viewModel.setUser(newUser);
        } else {
            Toast.makeText(this, "Kolom Umur tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    }
}