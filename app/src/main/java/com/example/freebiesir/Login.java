package com.example.freebiesir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.freebiesir.Model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private ImageButton loginBtn;
    private EditText phoneInput, passwordInput;
    private ProgressDialog loadingBar;

    private String parentDbName = "Users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (ImageButton) findViewById(R.id.image_login_Button);
        phoneInput = (EditText)findViewById(R.id.login_phone_input);
        passwordInput = (EditText)findViewById(R.id.login_password_input);
        loadingBar = new ProgressDialog(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String phone = phoneInput.getText().toString();
        String password = passwordInput.getText().toString();

        if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Ведите номер пожалуйста", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Ведите пароль", Toast.LENGTH_SHORT).show();

        }
        else
        {
            loadingBar.setTitle("Вход!");
            loadingBar.setMessage("Ожидайте :)");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();


            ValidateUser(phone,password);
        }
        }

    private void ValidateUser(String phone, String password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.child(parentDbName).child(phone).exists())
                {
                    Users usersData = snapshot.child(parentDbName).child(phone).getValue(Users.class);

                    if(usersData.getPhone().equals(phone))
                    {
                        if(usersData.getPass().equals(password))
                        {
                            loadingBar.dismiss();
                            Toast.makeText(Login.this, "Успешный вход!", Toast.LENGTH_SHORT).show();


                            Intent homeIntent = new Intent(Login.this, HomeActivity.class);
                            startActivity(homeIntent);
                        }
                        else
                        {
                            loadingBar.dismiss();
                            Toast.makeText(Login.this, "Неверный пароль", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else {
                       loadingBar.dismiss();
                       Toast.makeText(Login.this, "Такой номер " + phone + " еще не зарегестрированый", Toast.LENGTH_SHORT).show();
                       Intent registerIntent = new Intent(Login.this, RegistrationActivity.class);
                       startActivity(registerIntent);
                    }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

