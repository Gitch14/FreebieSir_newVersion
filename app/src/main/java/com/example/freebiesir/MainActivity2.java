package com.example.freebiesir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {

    private ImageButton registrationButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loginButton = (ImageButton) findViewById(R.id.login_button);

        registrationButton = (ImageButton) findViewById(R.id.registration_button);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(MainActivity2.this, Login.class);
                startActivity(loginIntent);


            }
        });

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regIntent = new Intent(MainActivity2.this, RegistrationActivity.class);
                startActivity(regIntent);
            }
        });
    }
}