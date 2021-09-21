package com.example.freebiesir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {

    private ImageButton regButton;
    private EditText userName_input, phone_input_reg, pass_input, sec_pass_input;
    private ProgressDialog londingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        regButton = (ImageButton) findViewById(R.id.image_reg_Button);
        userName_input = (EditText)findViewById(R.id.login_name_input);
        phone_input_reg = (EditText)findViewById(R.id.login_phone_input);
        pass_input = (EditText)findViewById(R.id.login_password_input);
        sec_pass_input = (EditText)findViewById(R.id.login_password_two_input);
        londingBar = new ProgressDialog(this);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAcount();
            }
        });
    }

    private void CreateAcount() {
        String name = userName_input.getText().toString();
        String phone = phone_input_reg.getText().toString();
        String password = pass_input.getText().toString();
        String second_password = sec_pass_input.getText().toString();

        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(this, "Ведите логин пожалуйста", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Ведите номер пожалуйста", Toast.LENGTH_SHORT).show();

        }
        else if(phone.length()>10)
        {
            Toast.makeText(this, "Ведите полный номер пожалуйста", Toast.LENGTH_SHORT).show();

        }
        else if(password.length()>5)
        {
            Toast.makeText(this, "Пароль должен быть больше 5 символов", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Ведите пароль", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(second_password))
        {
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();

        }
        else if(!Objects.equals(password, second_password))
        {
            Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();

        }
        else {
        }
        londingBar.setTitle("Создание аккаунта!");
        londingBar.setMessage("Ожидайте :)");
        londingBar.setCanceledOnTouchOutside(false);
        londingBar.show();
        Intent loginIntent = new Intent(RegistrationActivity.this, Login.class);
        startActivity(loginIntent);

        ValidatePhone(name,phone,password,second_password);
        }

    private void ValidatePhone(String name, String phone, String password, String second_password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @org.jetbrains.annotations.NotNull DataSnapshot snapshot) {
                if (!(snapshot.child("User").child(phone).exists())){

                    HashMap<String, Object> userDataMap = new HashMap<>();
                    userDataMap.put("Phone", phone);
                    userDataMap.put("Name", name);
                    userDataMap.put("Pass", password);

                    RootRef.child("Users").child(phone).updateChildren(userDataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        londingBar.dismiss();
                                        Toast.makeText(RegistrationActivity.this, "Ригистрация прошла успешно", Toast.LENGTH_SHORT);


                                    }
                                    else {
                                        londingBar.dismiss();
                                        Toast.makeText(RegistrationActivity.this, "Ошибка", Toast.LENGTH_SHORT);

                                    }
                                }
                            });

                }
                else {

                    Toast.makeText(RegistrationActivity.this, "Номер"+ phone + "Уже зарегистрирован", Toast.LENGTH_SHORT).show();
                    londingBar.dismiss();
                    Intent loginIntent = new Intent(RegistrationActivity.this, Login.class);
                    startActivity(loginIntent);
                }


            }

            @Override
            public void onCancelled(@NonNull @org.jetbrains.annotations.NotNull DatabaseError error) {

            }
        });
    }

}
