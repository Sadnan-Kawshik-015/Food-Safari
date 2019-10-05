package com.example.foodsafari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserSignInPage extends AppCompatActivity implements View.OnClickListener {

    private Button userRegisterButton;

    private EditText userNameEditText;
    private EditText userEmailEditText;
    private EditText userPhnoEditText;
    private EditText userPasswordEditText;
    private EditText userAcnoEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in_page);

        userNameEditText = findViewById(R.id.userNameEditText);
        userEmailEditText = findViewById(R.id.userEmailEditText);
        userPhnoEditText = findViewById(R.id.userPhnoEditText);
        userPasswordEditText = findViewById(R.id.userPasswordEditText);
        userAcnoEditText = findViewById(R.id.userAcnoEditText);

        userRegisterButton = findViewById(R.id.userRegisterButton);

        userRegisterButton.setOnClickListener(this);



    }


    public  void onClick(View v){
        switch (v.getId()){
            case R.id.userRegisterButton:

                break;


        }

    }


}
