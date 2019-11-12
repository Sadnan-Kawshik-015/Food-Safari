package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RestaurantMenu extends AppCompatActivity {

    RecyclerView recyclerView;
    List<FoodData>myFoodList;
    FoodData mFoodData;

    private DatabaseReference mDatabaseRef;

    /**Recyler view for menu item**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_menu);
        recyclerView=findViewById(R.id.rv_restaurant_menu);



        //getSupportActionBar().setTitle("Items");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GridLayoutManager gridLayoutManager=new GridLayoutManager(RestaurantMenu.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        myFoodList=new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Res_owner_menu").child(Constant.user_res_choice);

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Upload_Food upload = postSnapshot.getValue(Upload_Food.class);

                    if(upload.getStatus() == 1){


                        mFoodData = new FoodData(upload.getName(),upload.getDate(),upload.getPrice(),upload.getImageUrl(),"Available");

                        myFoodList.add(mFoodData);

                        FoodAdapter foodAdapter=new FoodAdapter(RestaurantMenu.this,myFoodList);
                        recyclerView.setAdapter(foodAdapter);


                    }



                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                System.out.println("Error");
                //Toast.makeText(MenuFragment.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                //mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });


    }
}
