package com.example.foodsafari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RestaurantRegistration extends AppCompatActivity {

    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_registration);

        signUpButton = (Button) findViewById(R.id.signUpButton);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openActivityResSignUp();

            }
        });
    }

    public void openActivityResSignUp(){

        Intent intent = new Intent(this,RestaurantSignUp.class);
        startActivity(intent);
    }
}
