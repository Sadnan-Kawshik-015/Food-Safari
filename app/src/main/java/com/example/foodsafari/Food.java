package com.example.foodsafari;

public class Food {

    private String name;
    private String restaurentName;
    private String description;
    private int unitPrice;




    public Food(String name, String restaurentName, String description, int unitPrice) {
        this.name = name;
        this.restaurentName = restaurentName;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public Food() {
    }

    public String getRestaurentName() {
        return restaurentName;
    }

    public void setRestaurentName(String restaurentName) {
        this.restaurentName = restaurentName;
    }

    public String getDescription() {
        return description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
