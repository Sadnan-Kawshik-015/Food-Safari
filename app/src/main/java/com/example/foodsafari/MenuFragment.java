package com.example.logintest;



import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

/**The User News Feed Main Fragment.It is fragment as it is a part of navigation drawer**/

public class MenuFragment extends Fragment {

    RecyclerView resRecylerView;
    List<RestaurantData>myRestaurantList;

    SearchView resSearchView;/**This feature is here to implement the search functionality.
     To watch further check out https://www.youtube.com/watch?v=f1nC8HcbMOw**/

    RestaurantData restaurantData;
    /**RestaurantData is the class that contains how restaurant item will look like*
     You will get that*/

    private DatabaseReference mDatabaseRef;

    //private MyAdopter myAdopter;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /**This is like OnCreate function of any fragment **/

        final View view= inflater.inflate(R.layout.fragment_menu,container,false);

        resRecylerView=(RecyclerView)view.findViewById(R.id.rv_user_news_feed);

        resSearchView=view.findViewById(R.id.sv_restaurant_list);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),1);

        resRecylerView.setLayoutManager(gridLayoutManager);


        /**The portion to show data in newsfeed.We need to extract data from fire base as restaurant
         * object and store it in the list for this check
         * https://www.youtube.com/watch?v=onU9nkwEC84&list=PLtZcxNkZv4_esv_dFKJgCZNGz8el93OLy&index=4**/

        myRestaurantList=new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Restaurants");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    RestaurantsARGS upload = postSnapshot.getValue(RestaurantsARGS.class);

                    String pass = postSnapshot.getKey();

                    Random r = new Random();

                    int val =  r.nextInt(11)+1;

                    int rem = val;
                    if(rem==1)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.f10,pass);
                    else if(rem==2)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.f9,pass);
                    else if(rem==3)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.f8,pass);
                    else if(rem==4)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.img_food_item,pass);
                    else if(rem==5)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.img_food_item_2,pass);
                    else if(rem==6)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.f7,pass);
                    else if(rem==7)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.f6,pass);
                    else if(rem==8)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.f5,pass);
                    else if(rem==9)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.f4,pass);
                    else if(rem==10)restaurantData = new RestaurantData(upload.getrName(),upload.getrDiscount()+" %",R.drawable.f3,pass);
                    myRestaurantList.add(restaurantData);
                }

                //myAdopter = new MyAdopter(MenuFragment.this, myRestaurantList);

                MyAdopter myAdopter=new MyAdopter(view.getContext(),myRestaurantList);

                resRecylerView.setAdapter(myAdopter);
                //mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                System.out.println("Error");
                //Toast.makeText(MenuFragment.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                //mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });

        /*
        restaurantData=new RestaurantData("Hot Cake","10% Off",R.drawable.img_food_item);

        myRestaurantList.add(restaurantData);

        restaurantData=new RestaurantData("Tacos","15% Off",R.drawable.img_food_item_2);

        myRestaurantList.add(restaurantData);

        restaurantData=new RestaurantData("Mr.Baker","5% Off",R.drawable.img_food_item);

        myRestaurantList.add(restaurantData);

        restaurantData=new RestaurantData("Mr.Manik Foods","10% Off",R.drawable.img_food_item_2);

        myRestaurantList.add(restaurantData);

        restaurantData=new RestaurantData("Chilox","30% Off",R.drawable.img_food_item_2);

        myRestaurantList.add(restaurantData);

        final MyAdopter myAdopter=new MyAdopter(view.getContext(),myRestaurantList);

        resRecylerView.setAdapter(myAdopter);
        */

        /**This portion has been done the search restaurant portion**/

        final MyAdopter myAdopter2=new MyAdopter(view.getContext(),myRestaurantList);

        resSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                myAdopter2.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }


}