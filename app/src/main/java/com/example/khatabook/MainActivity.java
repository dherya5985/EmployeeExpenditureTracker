package com.example.khatabook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    TextView employeename,employeeid,phoneno,email,empnamedisplay;
    DrawerLayout drawerLayout;
    String welcometxt,phonetxt,employeeidtxt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        drawerLayout = findViewById(R.id.drawer_layout);


        employeename = (TextView)findViewById(R.id.empname);
        employeeid = (TextView)findViewById(R.id.empiddis);
        phoneno = (TextView)findViewById(R.id.phonedis);
        email = (TextView)findViewById(R.id.empemail);
        empnamedisplay = (TextView)findViewById(R.id.welcomemessage);

        showAllUserData();

    }


    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickHome(View view){
        recreate();
    }

    public void ClickAddExpense(View view){
        redirectAct(this,Addexpense.class);
    }

    public void ClickViewExpense(View view){
        redirectAct(this,Viewexpenses.class);
    }
    public void ClickLogout(View view){
        redirectAct(this,Login.class);
    }


    public static void redirectAct(Activity activity,Class aClass) {
        Intent intent = new Intent(activity,aClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }


    private void showAllUserData() {

        GlobalClass globalClass = (GlobalClass) getApplicationContext();

        employeename.setText(globalClass.getNametosend());
        email.setText(globalClass.getEmailtosend());
        welcometxt = "Welcome "+globalClass.getNametosend();
        phonetxt = "Phone Number : +91"+globalClass.getPhonetosend();
        employeeidtxt = "Employee ID : "+globalClass.getIdtosend();
        empnamedisplay.setText(welcometxt);
        employeeid.setText(employeeidtxt);
        phoneno.setText(phonetxt);

    }
}
