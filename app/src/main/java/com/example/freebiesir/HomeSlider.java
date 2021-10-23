package com.example.freebiesir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeSlider extends AppCompatActivity {

    private ImageButton startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_slider);

        startButton = (ImageButton) findViewById(R.id.start_button);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent srart = new Intent(HomeSlider.this, MainActivity2.class);
                startActivity(srart);


            }
        });
    }
}