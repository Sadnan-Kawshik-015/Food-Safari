package com.example.logintest;

public class Person {
    String name;
    String email;
    String userName;
    String location;

    public Person(String name, String email, String userName, String location) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.location = location;
    }

    public Person(String name, String email, String userName) {
        this.name = name;
        this.email = email;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
