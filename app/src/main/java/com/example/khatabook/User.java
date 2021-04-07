package com.example.khatabook;

public class User {
    String Name;
     String Email;
    String Phone;
    String Password;
   String Employeeid;

    public User(String name, String email, String phone, String password, String employeeid) {
        this.Name = name;
        this.Email = email;
        this.Phone = phone;
        this.Password = password;
        this.Employeeid = employeeid;
    }



    public User() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmployeeid() {
        return Employeeid;
    }

    public void setEmployeeid(String employeeid) {
        Employeeid = employeeid;
    }
}
