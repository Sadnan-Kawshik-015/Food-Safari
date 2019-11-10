package com.example.foodsafari;

import java.util.ArrayList;

public class orderList {

    private User user;

    private ArrayList<orders> orderlist = new ArrayList<>();

    public orderList(User user , orders order) {

        this.user = user;
        this.orderlist.add(order);
    }

    public void  addorder(orders order){
        orderlist.add(order);
    }

    public ArrayList<orders> getOrderlist() {
        return orderlist;
    }
}
