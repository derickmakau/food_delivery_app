package com.example.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,password;
private Button login;
private TextView register, recoverPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth=FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(EditText)findViewById(R.id.emailAddressId);
        password=(EditText)findViewById(R.id.loginpasswordId);
        login=(Button)findViewById(R.id.loginButtonId);
        register=(TextView)findViewById(R.id.loginRegisterId);
        recoverPassword=(TextView)findViewById(R.id.recoverPasswordId);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registerIntent=new Intent(login.this,registerScreen.class);
                startActivity(registerIntent);
            }
        });
        recoverPassword.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }
    private void loginUser(){
        String emailOne= email.getText().toString().trim();
        String passwordOne=password.getText().toString().trim();
        if(emailOne.isEmpty()){
            email.setError("your email is required!");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailOne).matches()){
            email.setError("please provide valid email!");
            email.requestFocus();}
        if(passwordOne.isEmpty()){
            password.setError("your password is required!");
            password.requestFocus();
            return;

        }
        mAuth.signInWithEmailAndPassword(emailOne, passwordOne).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(login.this, "Successfully logged in", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(login.this, display.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(login.this, "login failed!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}