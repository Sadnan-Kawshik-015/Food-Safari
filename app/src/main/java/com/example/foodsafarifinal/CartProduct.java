package com.example.foodsafarifinal;

public class CartProduct extends FoodData {

    private int quantity;


    public CartProduct(String foodName, String foodDetails, String foodPrice, int foodImage, String activeStatus,int quantity,String restaurantName) {
        super(foodName, foodDetails, foodPrice, foodImage, activeStatus,restaurantName);
        this.quantity=quantity;

    }

    public CartProduct(String foodName, String foodDetails, String foodPrice, int foodImage,int quantity,String restaurantName) {
        super(foodName, foodDetails, foodPrice, foodImage,restaurantName);
        this.quantity=quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
