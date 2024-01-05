package com.example.turist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.turist.R;

public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_intro);

        ConstraintLayout introBtn = findViewById(R.id.introBtn);
        introBtn.setOnClickListener(v -> {
            // Создаем Intent для перехода к MainActivity
            Intent intent = new Intent(IntroActivity.this, MainActivity.class);

            // Запускаем новую Activity
            startActivity(intent);
        });
    }
}
