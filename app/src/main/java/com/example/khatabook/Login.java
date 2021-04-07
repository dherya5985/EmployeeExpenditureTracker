package com.example.khatabook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    EditText mID,mPassword;
    Button mLoginBtn;
    TextView registerred;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mID = findViewById(R.id.idlogin);
        mPassword = findViewById(R.id.passwordlogin);
        progressBar = findViewById(R.id.progressBar2);
        mLoginBtn = findViewById(R.id.login);
        registerred = findViewById(R.id.donthaveacc);

        registerred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (!validateEmail() | !validatePassword()) {
                        return;
                    } else {
                        isUser();
                    }
                }
        });


        }
    private Boolean validateEmail() {
        String email = mID.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            mID.setError("ID is Required");
            return false;
        } else {
            mID.setError(null);
            return true;
        }


    }

    private Boolean validatePassword() {
        String password = mPassword.getText().toString().trim().replace(".",",");

        if (TextUtils.isEmpty(password)) {
            mPassword.setError("Password is Required");
            return false;
        } else {
            mPassword.setError(null);
            return true;
        }
    }



    private void isUser() {

        GlobalClass globalClass = (GlobalClass) getApplicationContext();

        String userEnteredid = mID.getText().toString().trim().replace(".",",");
        String userEnteredpassword = mPassword.getText().toString().trim().replace(".",",");

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("employeeid").equalTo(userEnteredid);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    mID.setError(null);

                    String passwordfromDB = snapshot.child(userEnteredid).child("password").getValue(String.class);

                    if (passwordfromDB.equals(userEnteredpassword)) {
                        mID.setError(null);

                        String namefromDB = snapshot.child(userEnteredid).child("name").getValue(String.class);
                        String phonefromDB = snapshot.child(userEnteredid).child("phone").getValue(String.class);
                        String employeeidfromDB = snapshot.child(userEnteredid).child("employeeid").getValue(String.class);
                        String emailfromDB = snapshot.child(userEnteredid).child("email").getValue(String.class);

                        globalClass.setNametosend(namefromDB);
                        globalClass.setPhonetosend(phonefromDB);
                        globalClass.setIdtosend(employeeidfromDB);
                        globalClass.setEmailtosend(emailfromDB);


                        Intent intent = new Intent(Login.this,MainActivity.class);
                        startActivity(intent);
                        progressBar.setVisibility(View.VISIBLE);

                    } else {
                        mPassword.setError("Wrong Password");
                        mPassword.requestFocus();
                    }
                } else {
                    mID.setError("No such user exists");
                    mID.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    }

