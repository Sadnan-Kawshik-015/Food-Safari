package com.example.foodsafari;

public class User {

    private String name;
    private String email;
    private String phno;
    private String password;


    public User(String name, String email, String phno, String password) {
        this.name = name;
        this.email = email;
        this.phno = phno;
        this.password = password;
    }

    public User(String email , String password) {
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
