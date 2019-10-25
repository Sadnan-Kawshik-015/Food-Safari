package com.example.foodsafari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.logintest.LogInActivity;

public class userSelection extends AppCompatActivity implements View.OnClickListener {

    private Button userSelectButton;
    private Button ownerSelectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);

        userSelectButton = findViewById(R.id.logAsUserbutton);
        ownerSelectButton = findViewById(R.id.logAsOwnerbutton);


    }


    @Override
    public void onClick(View v){

        switch (v.getId()){

            case R.id.logAsUserbutton:
                Intent intent1 = new Intent(getApplicationContext(),UserLoginPage.class);
                startActivity(intent1);

             break;

            case R.id.logAsOwnerbutton:
                Intent intent2 = new Intent(getApplicationContext(), LogInActivity.class);
                startActivity(intent2);

                break;
        }

    }



}
