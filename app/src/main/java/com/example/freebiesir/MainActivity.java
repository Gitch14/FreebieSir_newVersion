package com.example.freebiesir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton registrationButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            loginButton = (ImageButton) findViewById(R.id.login_button);

            registrationButton = (ImageButton) findViewById(R.id.registration_button);


            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent loginIntent = new Intent(MainActivity.this, Login.class);
                    startActivity(loginIntent);


                }
            });

            registrationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent regIntent = new Intent(MainActivity.this, RegistrationActivity.class);
                    startActivity(regIntent);
                }
            });
        }

}
