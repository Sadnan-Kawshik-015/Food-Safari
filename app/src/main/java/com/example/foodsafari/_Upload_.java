package com.example.logintest;

public class Upload {

    private String Name;
    private String imageUrl;


    public Upload() {
        //empty constructor needed
    }

    public Upload(String imgName, String imageUrl) {
        if (imgName.trim().equals("")) {
            this.Name = "No Name";
        }

        Name = imgName;
        this.imageUrl = imageUrl;

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



}
