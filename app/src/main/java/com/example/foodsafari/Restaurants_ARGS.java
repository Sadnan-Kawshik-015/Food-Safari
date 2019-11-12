package com.example.logintest;

public class RestaurantsARGS {

    private String rName;
    private String rDiscount;

    public RestaurantsARGS() {

    }

    public RestaurantsARGS(String rName, String rDiscount) {
        this.rName = rName;
        this.rDiscount = rDiscount;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrDiscount() {
        return rDiscount;
    }

    public void setrDiscount(String rDiscount) {
        this.rDiscount = rDiscount;
    }

}
