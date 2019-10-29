package com.example.foodsafarifinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RestaurantDashboard extends AppCompatActivity {
    Button info,settings,addFood,showMenu,helpLine,logout;
    LinearLayout linearLayout;

    /**Dashboard for owner**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_dashboard);
        info=(Button)findViewById(R.id.btn_restaurant_info);
        settings=(Button)findViewById(R.id.btn_restaurant_settings);
        addFood=(Button)findViewById(R.id.btn_add_food);
        showMenu=(Button)findViewById(R.id.btn_restaurant_show_menu);
        helpLine=(Button)findViewById(R.id.btn_restaurant_helpline);
        logout=(Button)findViewById(R.id.btn_restaurant_logout);
        linearLayout=findViewById(R.id.ll_restaurant_about);
        getSupportActionBar().setTitle("Menu");

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantDashboard.this,"Best Seller",Toast.LENGTH_SHORT).show();
                changeActivity(RestaurantInfo.class);
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantDashboard.this,"Settings",Toast.LENGTH_SHORT).show();
                changeActivity(RestaurantSettings.class);
            }
        });
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantDashboard.this,"Add Food",Toast.LENGTH_SHORT).show();
                changeActivity(UpdateFood.class);
            }
        });
        showMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantDashboard.this,"Menu",Toast.LENGTH_SHORT).show();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(MainActivity.class);
                //Toast.makeText(MainActivity.this,"Logout",Toast.LENGTH_SHORT).show();

            }
        });
        helpLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantDashboard.this,"Helpline",Toast.LENGTH_SHORT).show();
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RestaurantDashboard.this,"About Info",Toast.LENGTH_SHORT).show();
                changeActivity(RestaurantInfo.class);
            }
        });

    }
    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(this,destination);
        //intent.putExtra("Player Choice",result);
        startActivity(intent);
        //finish();
    }
}
