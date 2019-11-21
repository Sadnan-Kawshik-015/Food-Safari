package com.example.logintest;

/**This class contains all menu item characteristics**/

public class FoodData {

    private String foodName;
    private String foodDetails;
    private String foodPrice;
    private String foodImage;
    private String activeStatus;

    private int img;

    private String restaurantName;

    public FoodData(String foodName, String foodDetails, String foodPrice, String foodImage, String activeStatus, String restaurantName) {
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.activeStatus = activeStatus;
        this.restaurantName=restaurantName;
    }

    public FoodData(String foodName, String foodDetails, String foodPrice, String foodImage, String activeStatus) {
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.activeStatus = activeStatus;
    }
    public FoodData(String foodName, String foodDetails, String foodPrice, String foodImage) {
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.activeStatus="Active";
    }
    public FoodData(String foodName, String foodDetails, String foodPrice, int foodImage) {
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.img = foodImage;
        this.activeStatus="Active";
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodDetails() {
        return foodDetails;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public int getImg() { return img; }

    public String getActiveStatus() {
        return activeStatus;
    }

    public String getRestaurantName() { return restaurantName; }
}
