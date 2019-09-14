package com.example.foodsafari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewLogo = (ImageView) findViewById(R.id.logo);
        imageViewLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivityResRegistration();

            }
        });
    }

    public void openActivityResRegistration(){

        Intent intent = new Intent(this,RestaurantRegistration.class);
        startActivity(intent);

    }
}
