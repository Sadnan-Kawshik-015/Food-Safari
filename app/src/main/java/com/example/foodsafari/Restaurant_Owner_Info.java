package com.example.logintest;

public class RestaurantOwnerInfo {

    private String name;
    private String email;
    private String rName;
    private String rLocation;

    public RestaurantOwnerInfo(String name, String email, String rName, String rLocation) {
        this.name = name;
        this.email = email;
        this.rName = rName;
        this.rLocation = rLocation;
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

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrLocation() {
        return rLocation;
    }

    public void setrLocation(String rLocation) {
        this.rLocation = rLocation;
    }

}