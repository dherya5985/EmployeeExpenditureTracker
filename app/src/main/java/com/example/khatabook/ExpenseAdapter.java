package com.example.khatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.List;

public class ExpenseAdapter extends FirebaseRecyclerAdapter<Expense,ExpenseAdapter.ExpenseViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ExpenseAdapter(@NonNull FirebaseRecyclerOptions<Expense> options) {
        super(options);
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_layout,parent,false);
        ExpenseViewHolder holder = new ExpenseViewHolder(view);
        return holder;
    }


    @Override
    protected void onBindViewHolder(@NonNull ExpenseViewHolder expenseViewHolder, int i, @NonNull Expense expense) {
        expenseViewHolder.expid.setText(expense.getExpenseid());
        expenseViewHolder.empid.setText(expense.getEmployeeid());
        expenseViewHolder.expname.setText(expense.getExpensename());
        expenseViewHolder.exploc.setText(expense.getLocation());
        expenseViewHolder.expdate.setText(expense.getDate());
        expenseViewHolder.exptime.setText(expense.getTime());
        expenseViewHolder.expreim.setText(expense.getReimburse());
        expenseViewHolder.expamt.setText(expense.getAmount());

    }


    class ExpenseViewHolder extends RecyclerView.ViewHolder{

        TextView expid,empid,expname,expamt,exploc,expreim,expdate,exptime;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            expid = itemView.findViewById(R.id.listexpid);
            empid = itemView.findViewById(R.id.listempid);
            expname = itemView.findViewById(R.id.listexpname);
            expamt = itemView.findViewById(R.id.listexpamt);
            exploc = itemView.findViewById(R.id.listexploc);
            expreim = itemView.findViewById(R.id.listexpreim);
            expdate = itemView.findViewById(R.id.listexpdate);
            exptime = itemView.findViewById(R.id.listexptime);
        }
    }
}
