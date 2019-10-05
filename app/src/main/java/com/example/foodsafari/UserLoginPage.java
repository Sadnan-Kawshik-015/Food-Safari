package com.example.foodsafari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

public class UserLoginPage extends AppCompatActivity implements View.OnClickListener {

    private EditText loginEmailEditText;
    private EditText loginPasswordEditText;
    private Button loginButton;
    private Button signUpButton;
    private Button backButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_page);

        loginEmailEditText = findViewById(R.id.loginEditTextUserName);
        loginPasswordEditText = findViewById(R.id.loginEditTextPassword);
        loginButton = findViewById(R.id.loginButton);
        signUpButton = findViewById(R.id.signUpButton);

        loginButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);

    }

        @Override
        public void onClick(View v ){

            switch (v.getId()){

                case R.id.loginButton:

                    break;


                case R.id.signUpButton:

                    break;



            }

        }


}
