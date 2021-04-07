package com.example.khatabook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText mFullName,mEmail,mPassword,mPhone,mEmployeeID;
    Button mRegisterBtn;
    TextView mLoginBtn;
    ProgressBar progressBar;
      FirebaseDatabase database;
     DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFullName = findViewById(R.id.nameregister);
        mEmail = findViewById(R.id.emailregister);
        mPassword = findViewById(R.id.passwordregister);
        mPhone = findViewById(R.id.phonenumber);
        mRegisterBtn = findViewById(R.id.register);
        mLoginBtn = findViewById(R.id.alreadyhaveacc);
        progressBar = findViewById(R.id.progressBar);
        mEmployeeID = findViewById(R.id.employeeid);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");


                String email = mEmail.getText().toString().trim().replace(".",",");
                String employeeid = mEmployeeID.getText().toString().trim().replace(".",",");
                String password = mPassword.getText().toString().trim().replace(".",",");
                String phone = mPhone.getText().toString().trim().replace(".",",");
                String name = mFullName.getText().toString().trim().replace(".",",");

                if (TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(employeeid)){
                    mEmail.setError("Employee ID is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required");
                    return;
                }
                if (password.length() < 6){
                    mPassword.setError("Password must be equal to or more than 6 Characters");
                    return;
                }

                User newuser = new User(name , email , phone , password , employeeid);
                reference.child(employeeid).setValue(newuser);
                progressBar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
                progressBar.setVisibility(View.VISIBLE);
            }
        });

    }
}