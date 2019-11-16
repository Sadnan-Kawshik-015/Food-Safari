package com.example.foodsafarifinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CartProduct>myCartList;
    CartProduct mCartProduct;
    TextView totalPrice;
    Button orderNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        getSupportActionBar().setTitle("My Cart");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=findViewById(R.id.rv_my_cart);
        totalPrice=findViewById(R.id.tv_total_price_cart);
        orderNext=findViewById(R.id.btn_order_next);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(MyCart.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        myCartList=new ArrayList<>();
        mCartProduct=new CartProduct("Burger","A Bread Dish With Patty Inside","350",R.drawable.img_food_item,5,"Tacos");
        myCartList.add(mCartProduct);

        CartItemAdapter cartItemAdapter=new CartItemAdapter(MyCart.this,myCartList);
        recyclerView.setAdapter(cartItemAdapter);
    }
}
