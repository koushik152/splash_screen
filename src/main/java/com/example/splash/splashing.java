package com.example.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splashing extends AppCompatActivity {
    private static final int SPLASH_DURATION = 8000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splashing);
        ImageView imageView = findViewById(R.id.imageView);

        // Load animation
         Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Apply animation to image view
        imageView.startAnimation(animation);

        // Start main activity after splash duration
        new Handler().postDelayed(() -> {
            // Start the main activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            // Finish the splash activity
            finish();
        }, SPLASH_DURATION);
    }
}
