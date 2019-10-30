package com.example.foodsafarifinal;


/**This class contains all menu item characteristics**/

public class FoodData {

    private String foodName;
    private String foodDetails;
    private String foodPrice;
    private int foodImage;
    private String activeStatus;

    public FoodData(String foodName, String foodDetails, String foodPrice, int foodImage, String activeStatus) {
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.activeStatus = activeStatus;
    }
    public FoodData(String foodName, String foodDetails, String foodPrice, int foodImage) {
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
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

    public int getFoodImage() {
        return foodImage;
    }

    public String getActiveStatus() {
        return activeStatus;
    }
}
