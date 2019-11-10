package com.example.foodsafari;


import java.sql.Time;
import java.util.Date;

public class orders {

    private String restaurentName;
    private String restaurentOwnerEmail;
    private String userEmail;
    private Food food;
    private int quantity;
    private Date orderDate;
    private Time orderTime;


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Time getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }



    public orders(String restaurentName, String userEmail, Food food, int quantity) {
        this.restaurentName = restaurentName;
        this.userEmail = userEmail;
        this.food = food;
        this.quantity = quantity;
    }


    public orders(String restaurentName, String restaurentOwnerEmail, String userEmail, Food food, int quantity, Date orderDate, Time orderTime) {
        this.restaurentName = restaurentName;
        this.restaurentOwnerEmail = restaurentOwnerEmail;
        this.userEmail = userEmail;
        this.food = food;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.orderTime = orderTime;
    }

    public String getRestaurentName() {
        return restaurentName;
    }

    public void setRestaurentName(String restaurentName) {
        this.restaurentName = restaurentName;
    }

    public String getRestaurentOwnerEmail() {
        return restaurentOwnerEmail;
    }

    public void setRestaurentOwnerEmail(String restaurentOwnerEmail) {
        this.restaurentOwnerEmail = restaurentOwnerEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAmount(){

        return quantity*food.getUnitPrice();
    }
}
