package com.example.foodsafarifinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantInfo extends AppCompatActivity {
    TextView owner_name,email,restaurant_name,location;
    ImageView owner_pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_info);

        owner_name=findViewById(R.id.tv_restaurant_owner_name);
        owner_pic=findViewById(R.id.iv_restaurant_owner_image);
        email=findViewById(R.id.tv_restaurant_owner_email);
        restaurant_name=findViewById(R.id.tv_restaurant_owner_info_restaurant_name);
        location=findViewById(R.id.tv_restaurant_owner_restaurant_location);

    }
    public void changeText(String input,TextView t)
    {
        t.setText(input);
    }
}
