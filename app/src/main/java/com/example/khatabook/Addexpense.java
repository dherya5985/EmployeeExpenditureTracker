package com.example.khatabook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class Addexpense extends AppCompatActivity {

    DrawerLayout drawerLayout;

    EditText name,date,id,time,amount,location;
    Button addexpense;
    CheckBox reimburse;
    ProgressBar progressBar;
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView nameonheader,emailonheader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addexpense);

        drawerLayout = findViewById(R.id.drawer_layout);
        GlobalClass globalClass = (GlobalClass) getApplicationContext();
        name = findViewById(R.id.nameofexpense);
        date = findViewById(R.id.dateofexpense);
        id = findViewById(R.id.expenseid);
        time = findViewById(R.id.timeofexpense);
        amount = findViewById(R.id.amountofexpenditure);
        location = findViewById(R.id.locationofexpense);
        reimburse = findViewById(R.id.reimbursablecheck);
        progressBar = findViewById(R.id.progressBar3);
        addexpense = findViewById(R.id.buttonexpense);
        nameonheader = findViewById(R.id.empname);
        emailonheader = findViewById(R.id.empemail);

        nameonheader.setText(globalClass.getNametosend());
        emailonheader.setText(globalClass.getEmailtosend());




        addexpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String employeeid = globalClass.getIdtosend();
                String nameofexpense = name.getText().toString().trim().replace(".",",");
                String expenseid = id.getText().toString().trim().replace(".",",");
                String dateofexpense =date.getText().toString().trim().replace(".",",");
                String timeofexpense = time.getText().toString().trim().replace(".",",");
                String amountofexpense = amount.getText().toString().trim().replace(".",",");
                String locationofexpense = location.getText().toString().trim().replace(".",",");
                String reimbursableaxpense;
                if (reimburse.isChecked()){
                    reimbursableaxpense = "Reimbursable";
                }
                else{
                    reimbursableaxpense = "Not Reimbursable";
                }

                if (TextUtils.isEmpty(nameofexpense)){
                    name.setError("Name of Expense is Required");
                    return;
                }
                if (TextUtils.isEmpty(expenseid)){
                    id.setError("Expense ID is Required");
                    return;
                }
                if (TextUtils.isEmpty(timeofexpense)){
                    time.setError("Enter Correct Time");
                    return;
                }
                if (TextUtils.isEmpty(locationofexpense)){
                    location.setError("Location of Expenditure is Required");
                    return;
                }

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("expenses");
                Expense newexpense = new Expense(expenseid,employeeid,nameofexpense,dateofexpense,timeofexpense,locationofexpense,amountofexpense,reimbursableaxpense);
                reference.child(expenseid).setValue(newexpense);
                progressBar.setVisibility(View.VISIBLE);
            }
        });


    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        MainActivity.redirectAct(this,MainActivity.class);
    }

    public void ClickAddExpense(View view){
        recreate();
    }

    public void ClickViewExpense(View view){
        MainActivity.redirectAct(this,Viewexpenses.class);
    }
    public void ClickLogout(View view){
        MainActivity.redirectAct(this,Login.class);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }



}


