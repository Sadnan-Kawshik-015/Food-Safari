package com.example.logintest;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class RestaurantInfo extends AppCompatActivity {
    /**Detail for owner.Need to create owner class to store**/
    TextView owner_name,owner_name2,email,restaurant_name,location;
    ImageView owner_pic;
    DatabaseReference ref,ref2;

    StorageReference storageReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_info);

        //getSupportActionBar().setTitle("Owner Information");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //storageReference = FirebaseStorage.getInstance().getReference("Res_Owner_Images_DP").child(Constant.getRes_owner_DP);

        owner_pic=findViewById(R.id.iv_restaurant_owner_image);
        owner_name=findViewById(R.id.tv_restaurant_owner_name);
        owner_name2=findViewById(R.id.tv_restaurant_owner_user_name);
        email=findViewById(R.id.tv_restaurant_owner_email);
        restaurant_name=findViewById(R.id.tv_restaurant_owner_info_restaurant_name);
        location=findViewById(R.id.tv_restaurant_owner_restaurant_location);

        ref2 = FirebaseDatabase.getInstance().getReference().child("Restaurant Owner DP").child(Constant.res_owner_pass);
        ref2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String link = dataSnapshot.child("imageUrl").getValue().toString();
                Picasso.get().load(link).into(owner_pic);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(RestaurantInfo.this,"Error ocurred",Toast.LENGTH_LONG).show();

            }
        });


        ref = FirebaseDatabase.getInstance().getReference().child("Restaurant Owner").child(Constant.res_owner_pass);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String own_name = dataSnapshot.child("name").getValue().toString();
                String own_user_name = dataSnapshot.child("name").getValue().toString();
                String own_email = dataSnapshot.child("email").getValue().toString();
                String res_name = dataSnapshot.child("rName").getValue().toString();
                String res_loc = dataSnapshot.child("rLocation").getValue().toString();

                //for(DataSnapshot post)


                changeText(own_name,owner_name);
                changeText(own_user_name,owner_name2);
                changeText(own_email,email);
                changeText(res_name,restaurant_name);
                changeText(res_loc,location);

                Toast.makeText(RestaurantInfo.this,"Your Profile",Toast.LENGTH_LONG).show();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(RestaurantInfo.this,"Error ocurred",Toast.LENGTH_LONG).show();

            }
        });



    }



    public void changeText(String input, TextView t)
    {

        t.setText(input);
    }

}