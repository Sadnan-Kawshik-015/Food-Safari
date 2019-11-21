package com.example.logintest;

public class UserInfo {

    private String name;
    private String email;
    private String rLocation;

    public UserInfo(String name, String email, String rLocation) {
        this.name = name;
        this.email = email;
        this.rLocation = rLocation;
    }
    public UserInfo() {

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

    public String getrLocation() {
        return rLocation;
    }

    public void setrLocation(String rLocation) {
        this.rLocation = rLocation;
    }
}
