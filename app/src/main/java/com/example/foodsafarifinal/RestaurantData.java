package com.example.foodsafarifinal;

public class RestaurantData {

    private String restaurantName;
    private String discount;
    private int restaurantImage;

    public RestaurantData(String restaurantName,String discount, int restaurantImage) {
        this.restaurantName = restaurantName;
        this.discount = discount;
        this.restaurantImage = restaurantImage;
    }

    public String getRestaurantName() {
        return restaurantName;
    }


    public String getDiscount() {
        return discount;
    }


    public int getRestaurantImage() {
        return restaurantImage;
    }
}
