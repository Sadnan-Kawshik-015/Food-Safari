package com.example.logintest;

public class CartProduct  {

    private String foodName;
    private String foodDetails;
    private String foodPrice;
    private String foodImage;
    private String activeStatus;
    private int quantity;
    private String restaurantName;

    //private int img;//


    public CartProduct() {

    }

    public CartProduct(String foodName, String foodDetails, String foodPrice, String foodImage, String activeStatus, int quantity, String restaurantName) {
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.activeStatus = activeStatus;
        this.quantity = quantity;
        this.restaurantName = restaurantName;
    }

    /*
    public CartProduct(String foodName, String foodDetails, String foodPrice, String foodImage, String activeStatus,int quantity,String restaurantName) {

        //super(foodName, foodDetails, foodPrice, foodImage, activeStatus,restaurantName);//Haven't used res_name

        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.activeStatus = activeStatus;
        this.restaurantName=restaurantName;
        this.quantity=quantity;


    }

    public CartProduct(String foodName, String foodDetails, String foodPrice, String foodImage,int quantity,String restaurantName) {

        //super(foodName, foodDetails, foodPrice, foodImage,restaurantName);
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.restaurantName=restaurantName;
        this.quantity=quantity;

    }

    public CartProduct(String foodName, String foodDetails, String foodPrice, int foodImage,int quantity,String restaurantName) {

        //super(foodName, foodDetails, foodPrice, foodImage,restaurantName);
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.img = foodImage;
        this.restaurantName=restaurantName;
        this.quantity=quantity;

    }
    */


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDetails() {
        return foodDetails;
    }

    public void setFoodDetails(String foodDetails) {
        this.foodDetails = foodDetails;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /*
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
    */

}

