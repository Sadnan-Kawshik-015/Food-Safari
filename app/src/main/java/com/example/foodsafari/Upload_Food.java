package com.example.logintest;

public class Upload_Food {

    private String Name;
    private String imageUrl;
    private int status;
    private String price;
    private String date;

    public Upload_Food() {
        //empty constructor needed
    }


    public Upload_Food(String imgName, String imageUrl, int status, String price, String date) {

        if (imgName.trim().equals("")) {
            this.Name = "No Name";
        }

        this.Name = imgName;
        this.imageUrl = imageUrl;
        this.status = status;
        this.price = price;
        this.date = date;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
