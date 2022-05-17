package com.example.fooddeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class registerScreen extends AppCompatActivity {
    private FirebaseAuth mAuth;
EditText firstName, lastName,email, password, confirmPassword;
Button registerButton;
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth=FirebaseAuth.getInstance();
        setContentView(R.layout.activity_register_screen);
        firstName=(EditText)findViewById(R.id.firstNameId);
        lastName=(EditText)findViewById(R.id.lastNameId);
        email=(EditText)findViewById(R.id.emailId);
        password=(EditText)findViewById(R.id.passwordId);
        confirmPassword=(EditText)findViewById(R.id.confirmPasswordId);
registerButton=(Button)findViewById(R.id.registerId);
progressDialog = new ProgressDialog(this);
registerButton.setOnClickListener(new View.OnClickListener(){

    @Override
    public void onClick(View v) {
        registerUser();
    }
});
    }
    private void registerUser(){
        String firstName1=firstName.getText().toString();
        String lastName1=lastName.getText().toString();
        String email1=email.getText().toString();
        String password1=password.getText().toString();
        String confirmPassword1=confirmPassword.getText().toString();
        if(firstName1.isEmpty()){
            firstName.setError("First Name is required!");
            firstName.requestFocus();
            return;
        }
        if(lastName1.isEmpty()){
            lastName.setError("Last Name is required!");
            lastName.requestFocus();
            return;
        }
        if(email1.isEmpty()){
            email.setError("email is required!");
            email.requestFocus();
            return;
        }
        /*if(!Patterns.EMAIL_ADDRESS.matcher((CharSequence) email).matches())-- brings error.*/
            if(!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
            email.setError("please provide valid email!");
            email.requestFocus();}
        if(password1.isEmpty()){
            password.setError("password is required!");
            password.requestFocus();
            return;
        }
        if(password1.length()<6){
            password.setError("Min password length should be 6 characters!");
            password.requestFocus();
            return;
        }
        if(confirmPassword1.isEmpty()){
            confirmPassword.setError("input your password");
            confirmPassword.requestFocus();
            return;
        }
        if(confirmPassword1==password1){
            confirmPassword.setError("confirmation password is ok!");
            confirmPassword.requestFocus();
            return;
        }
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
         mAuth.createUserWithEmailAndPassword(email1, password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
if(task.isSuccessful()){

    Toast.makeText(registerScreen.this,"Successfully registered.",Toast.LENGTH_SHORT).show();
Intent intent= new Intent(registerScreen.this,display.class);
startActivity(intent);
    finish();
}
else{
    Toast.makeText(registerScreen.this,"Failed to register!",Toast.LENGTH_LONG).show();
}
progressDialog.dismiss();
                    }
                });

        }
    }
