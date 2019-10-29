package com.example.foodsafarifinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FoodData>myFoodList;
    FoodData mFoodData;
    /**Recyler view for menu item**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);
        recyclerView=findViewById(R.id.rv_restaurant_menu);
        getSupportActionBar().setTitle("Items");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(RestaurantMenu.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        myFoodList=new ArrayList<>();

        mFoodData=new FoodData("Burger","A Bread Dish With Patty Inside","350",R.drawable.img_food_item_2,"OK");
        myFoodList.add(mFoodData);
        mFoodData=new FoodData("Kachhi","A Special Mutton Biriyani","150",R.drawable.img_food_item_2,"OK");
        myFoodList.add(mFoodData);
        mFoodData=new FoodData("Sandwitch","A Bread Dish With Meat Inside","50",R.drawable.img_food_item_2,"OK");
        myFoodList.add(mFoodData);
        mFoodData=new FoodData("Chocolate Cake","A Cake Made Of Chocolate","650",R.drawable.img_food_item,"OK");
        myFoodList.add(mFoodData);

        FoodAdapter foodAdapter=new FoodAdapter(RestaurantMenu.this,myFoodList);
        recyclerView.setAdapter(foodAdapter);
    }
}
