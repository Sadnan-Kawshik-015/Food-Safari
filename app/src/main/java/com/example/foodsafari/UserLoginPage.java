package com.example.foodsafari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserLoginPage extends AppCompatActivity implements View.OnClickListener {

    private EditText loginEmailEditText;
    private EditText loginPasswordEditText;
    private Button userLoginButton;
    private Button userSignUpButton;
    private Button backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_page);

        loginEmailEditText = findViewById(R.id.loginUserEmail);
        loginPasswordEditText = findViewById(R.id.loginUserPassword);
        userLoginButton = findViewById(R.id.userLoginButton);
        userSignUpButton = findViewById(R.id.userSignUpButton);
        backButton = findViewById(R.id.userLoginBackButton);

        userLoginButton.setOnClickListener(this);
        userSignUpButton.setOnClickListener(this);
    }


    @Override
    public  void onClick(View v){
        switch (v.getId()){
            case R.id.userLoginButton:

                break;

            case R.id.userSignUpButton:

                Intent intent1 = new Intent(getApplicationContext(),UserSignInPage.class);
                startActivity(intent1);
                break;

            case R.id.userLoginBackButton:

                Intent intent2 = new Intent(getApplicationContext(),userSelection.class);
                startActivity(intent2);
                break;
        }

    }
}
