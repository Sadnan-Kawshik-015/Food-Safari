package com.example.foodsafarifinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
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

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        /**This is like OnCreate function of any fragment **/

        View view= inflater.inflate(R.layout.fragment_menu,container,false);

        resRecylerView=(RecyclerView)view.findViewById(R.id.rv_user_news_feed);

        resSearchView=view.findViewById(R.id.sv_restaurant_list);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(view.getContext(),1);

        resRecylerView.setLayoutManager(gridLayoutManager);


        /**The portion to show data in newsfeed.We need to extract data from fire base as restaurant
         * object and store it in the list for this check
         * https://www.youtube.com/watch?v=onU9nkwEC84&list=PLtZcxNkZv4_esv_dFKJgCZNGz8el93OLy&index=4**/

        myRestaurantList=new ArrayList<>();


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

         /**This portion has been done the search restaurant portion**/

        resRecylerView.setAdapter(myAdopter);

        resSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                myAdopter.getFilter().filter(newText);
                return false;
            }
        });

        return view;
    }


}
