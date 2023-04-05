package com.example.gurudata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gurudata.databinding.ActivityChickenShopsBinding;

public class ChickenShops extends AppCompatActivity {
ActivityChickenShopsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =ActivityChickenShopsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}