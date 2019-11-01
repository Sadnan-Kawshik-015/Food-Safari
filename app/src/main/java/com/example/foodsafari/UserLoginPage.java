package com.example.foodsafari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserLoginPage extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private EditText loginEmailEditText;
    private EditText loginPasswordEditText;

    private String userEmail;
    private String userPassword;


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
        backButton.setOnClickListener(this);

        mFirebaseAuth = FirebaseAuth.getInstance();
       mAuthStateListener = new FirebaseAuth.AuthStateListener(){

           @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
               FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();

               if(mFirebaseUser != null){
                   Toast.makeText(UserLoginPage.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), userSelection.class));
               }
               else{
                   Toast.makeText(UserLoginPage.this,"Please Login",Toast.LENGTH_SHORT).show();
               }

           }

       };



    }


    @Override
    public  void onClick(View v){

        switch (v.getId()){




            case R.id.userLoginButton:

                userEmail = loginEmailEditText.getText().toString();
                userPassword = loginPasswordEditText.getText().toString();

                if(userEmail.isEmpty() ){
                    Toast.makeText(UserLoginPage.this,"Please fill your Email ID",Toast.LENGTH_SHORT).show();
                }
                else if(userPassword.isEmpty()){
                    Toast.makeText(UserLoginPage.this,"Please give your Password",Toast.LENGTH_SHORT).show();
                }

                else{
                    mFirebaseAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(UserLoginPage.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(UserLoginPage.this,"Login failed, Please try again",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                startActivity(new Intent(getApplicationContext(),UserLoginPage.class));
                            }
                        }
                    });


                    Toast.makeText(UserLoginPage.this,"You are Logged in",Toast.LENGTH_SHORT).show();
                }

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
