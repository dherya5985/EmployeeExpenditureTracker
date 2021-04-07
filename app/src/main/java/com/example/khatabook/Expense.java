package com.example.khatabook;
public class Expense{

    String Expenseid;
    String Expensename;
    String date;
    String time;
    String location;
    String amount;
    String reimburse;
    String Employeeid;



    public Expense(String expenseid, String employeeid, String expensename ,String date, String time, String location, String amount, String reimburse) {
        this.Expenseid = expenseid;
        this.Employeeid = employeeid;
        this.Expensename = expensename;
        this.date = date;
        this.time = time;
        this.location = location;
        this.amount = amount;
        this.reimburse = reimburse;

    }
    public Expense() {
    }
    public String getEmployeeid() {
        return Employeeid;
    }

    public void setEmployeeid(String employeeid) {
        Employeeid = employeeid;
    }


    public String getExpenseid() {
        return Expenseid;
    }

    public void setExpenseid(String expenseid) {
        Expenseid = expenseid;
    }

    public String getExpensename() {
        return Expensename;
    }

    public void setExpensename(String expensename) {
        Expensename = expensename;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReimburse() {
        return reimburse;
    }

    public void setReimburse(String reimburse) {
        this.reimburse = reimburse;
    }





}
