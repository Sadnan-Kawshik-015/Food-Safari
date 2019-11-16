package com.example.foodsafarifinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FoodData>myFoodList;

    FoodData mFoodData;
    String restaurantName;
    /**Recyler view for menu item**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);
        recyclerView=findViewById(R.id.rv_restaurant_menu);
        Intent intent=getIntent();
        restaurantName=intent.getStringExtra("RestaurantName");
       // System.out.println(restaurantName);
        Log.e("TAG",restaurantName);

        getSupportActionBar().setTitle("Items");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(RestaurantMenu.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        myFoodList=new ArrayList<>();

        mFoodData=new FoodData("Burger","A Bread Dish With Patty Inside","350",R.drawable.img_food_item_2,"OK",restaurantName);
        myFoodList.add(mFoodData);
        mFoodData=new FoodData("Kachhi","A Special Mutton Biriyani","150",R.drawable.img_food_item_2,"OK",restaurantName);
        myFoodList.add(mFoodData);
        mFoodData=new FoodData("Sandwitch","A Bread Dish With Meat Inside","50",R.drawable.img_food_item_2,"OK",restaurantName);
        myFoodList.add(mFoodData);
        mFoodData=new FoodData("Chocolate Cake","A Cake Made Of Chocolate","650",R.drawable.img_food_item,"OK",restaurantName);
        myFoodList.add(mFoodData);
        Log.e("tag",mFoodData.getRestaurantName());
        FoodAdapter foodAdapter=new FoodAdapter(RestaurantMenu.this,myFoodList);
        recyclerView.setAdapter(foodAdapter);

    }
}
