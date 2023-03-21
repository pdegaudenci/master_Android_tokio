package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.login.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setlistener();
    }

    private void setlistener() {
        binding.getPasswordBtn.setOnClickListener(this::showMessage);
        binding.createBtn.setOnClickListener(this::showMessage);
        binding.btnLogin.setOnClickListener(this::showMessage);
    }

    private void showMessage(View view) {
        switch (view.getId()){
            case R.id.get_password_btn:
                Snackbar.make(view,"EN CONSTRUCCION", BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
            case R.id.create_btn:
                Snackbar.make(view,"EN CONSTRUCCION", BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
            case R.id.btn_login:
                Snackbar.make(view,"EN CONSTRUCCION", BaseTransientBottomBar.LENGTH_SHORT).show();
                break;
        }
    }
}