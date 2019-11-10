package com.example.foodsafari;

public class RestaurentOwner {

    private String name;
    private String email;
    private String password;
    private String restaurentsName;
    private String restaurentsAddress;


    public String getName() {
        return name;
    }

    public RestaurentOwner(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RestaurentOwner(String name, String email, String password, String restaurentsName, String restaurentsAddress) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.restaurentsName = restaurentsName;
        this.restaurentsAddress = restaurentsAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRestaurentsName() {
        return restaurentsName;
    }

    public void setRestaurentsName(String restaurentsName) {
        this.restaurentsName = restaurentsName;
    }

    public String getRestaurentsAddress() {
        return restaurentsAddress;
    }

    public void setRestaurentsAddress(String restaurentsAddress) {
        this.restaurentsAddress = restaurentsAddress;
    }
}
