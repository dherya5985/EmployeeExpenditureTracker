package com.example.khatabook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Viewexpenses extends AppCompatActivity {

    RecyclerView recyclerview;
    ExpenseAdapter adapter;
    String employeeidview;
    DrawerLayout drawerLayout;
    TextView nameonheader,emailonheader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewexpenses);
        drawerLayout = findViewById(R.id.drawer_layout);
        GlobalClass globalClass = (GlobalClass) getApplicationContext();
        nameonheader = findViewById(R.id.empname);
        emailonheader = findViewById(R.id.empemail);

        nameonheader.setText(globalClass.getNametosend());
        emailonheader.setText(globalClass.getEmailtosend());
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        employeeidview = globalClass.getIdtosend();
        String userEnteredid = employeeidview.replace(".",",");
        FirebaseRecyclerOptions<Expense> options = new FirebaseRecyclerOptions.Builder<Expense>().setQuery(FirebaseDatabase.getInstance().getReference("expenses").orderByChild("employeeid").equalTo(userEnteredid),Expense.class).build();
        adapter = new ExpenseAdapter(options);
        recyclerview.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
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
        MainActivity.redirectAct(this,Addexpense.class);
    }
    public void ClickLogout(View view){
        MainActivity.redirectAct(this,Login.class);
    }

    public void ClickViewExpense(View view){
        recreate();
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



