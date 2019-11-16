package com.example.foodsafarifinal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyOrderFragment extends Fragment {

    /**Will Store previous orders in recyclerview.Has not been implemented yet.
     * I will do this if you want**/
    RecyclerView myOrderRecyclerView;
    List<FoodData>myFoodList;
    FoodData mFoodData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_my_orders,container,false);

        myOrderRecyclerView=(RecyclerView)view.findViewById(R.id.rv_my_order_list);


        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),1);

        myOrderRecyclerView.setLayoutManager(gridLayoutManager);

        myFoodList=new ArrayList<>();
        mFoodData=new FoodData("Burger","A Bread Dish With Patty Inside","350",R.drawable.img_food_item_2,"Tacos");
        myFoodList.add(mFoodData);
        mFoodData=new FoodData("Kachhi","A Special Mutton Biriyani","150",R.drawable.img_food_item_2,"Mr.Manik");
        myFoodList.add(mFoodData);
        mFoodData=new FoodData("Sandwitch","A Bread Dish With Meat Inside","50",R.drawable.img_food_item_2,"Takeout");
        myFoodList.add(mFoodData);
        mFoodData=new FoodData("Chocolate Cake","A Cake Made Of Chocolate","650",R.drawable.img_food_item,"Nanna Biriyani");
        myFoodList.add(mFoodData);

        MyOrderAdapter myOrderAdapter=new MyOrderAdapter(view.getContext(),myFoodList);
        myOrderRecyclerView.setAdapter(myOrderAdapter);

        return view;
    }
}
