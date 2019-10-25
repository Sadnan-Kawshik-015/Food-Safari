package com.example.foodsafari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserSignInPage extends AppCompatActivity implements View.OnClickListener {

    private Button userRegisterButton;
    private Button usbackButton;

    private EditText userNameEditText;
    private EditText userEmailEditText;
    private EditText userPhnoEditText;
    private EditText userPasswordEditText1;
    private  EditText userPasswordEditText2;


    private String userEmail;
    private String userName;
    private String userPhno;
    private  String userPassword1;
    private  String userPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_in_page);

        userNameEditText = findViewById(R.id.uNameEditText);
        userEmailEditText = findViewById(R.id.usEmailEditText);
        userPhnoEditText = findViewById(R.id.usPhnoEditText);
        userPasswordEditText1 = findViewById(R.id.usPasswordEditText1);
        userPasswordEditText2 = findViewById(R.id.usPasswordEditText2);

        userRegisterButton = findViewById(R.id.userRegisterButton);
        usbackButton = findViewById(R.id.usibackbutton);

        userRegisterButton.setOnClickListener(this);
        usbackButton.setOnClickListener(this);



    }


    public  void onClick(View v){
        switch (v.getId()){

            case R.id.userRegisterButton:

                userName = userNameEditText.getText().toString();
                userEmail = userEmailEditText.getText().toString();
                userPhno = userPhnoEditText.getText().toString();
                userPassword1 = userPasswordEditText1.getText().toString();
                userPassword2 = userPasswordEditText2.getText().toString();

                if(userName.isEmpty() || userEmail.isEmpty() || userPhno.isEmpty() || userPassword1.isEmpty() || userPassword2.isEmpty()){
                    Toast.makeText(UserSignInPage.this,"Please fill up all the fields",Toast.LENGTH_SHORT).show();
                }

                else if(!userPassword1.equals(userPassword2)){
                    Toast.makeText(UserSignInPage.this,"Passwords didn't match\n Try again",Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(UserSignInPage.this,"Thanks for Signing up ",Toast.LENGTH_SHORT).show();
                }


                break;


            case R.id.usibackbutton:

                Intent intent2 = new Intent(getApplicationContext(),UserLoginPage.class);
                startActivity(intent2);
                break;


        }

    }


}
