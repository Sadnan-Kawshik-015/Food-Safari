package com.example.foodsafarifinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class OwnerShowMenu extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FoodData> myFoodList;
    FoodData mFoodData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_show_menu);

        recyclerView=findViewById(R.id.rv_owner_show_menu);
        getSupportActionBar().setTitle("Menu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(OwnerShowMenu.this,1);
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

        OwnerMenuAdapter foodAdapter=new OwnerMenuAdapter(OwnerShowMenu.this,myFoodList);
        recyclerView.setAdapter(foodAdapter);

    }
}
