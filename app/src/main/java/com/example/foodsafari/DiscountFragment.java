package com.example.logintest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class DiscountFragment extends Fragment {

    /**Still haven't done the work in this.Anyone want to do just let me know**/

    EditText emailID,password,password_confm;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_discount,container,false);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailID = view.findViewById(R.id.emlSP);
        password = view.findViewById(R.id.psdSP);
        password_confm = view.findViewById(R.id.psdSP_confm);
        btnSignUp = view.findViewById(R.id.btnSP);
        tvSignIn = view.findViewById(R.id.tvALD);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailID.getText().toString();
                String pwd = password.getText().toString();
                String pwd_con = password_confm.getText().toString();

                if(email.isEmpty()){

                    emailID.setError("Please enter your email ID");
                    emailID.requestFocus();

                }
                else if(pwd.isEmpty()){

                    password.setError("Please enter your password");
                    password.requestFocus();

                }
                else if(email.isEmpty() && pwd.isEmpty()){

                    //Toast.makeText(this,"Fields are empty",Toast.LENGTH_SHORT).show();
                    emailID.setError("Please enter your email ID");
                    emailID.requestFocus();
                    password.setError("Please enter your password");
                    password.requestFocus();

                }
                else if((!email.isEmpty() && !pwd.isEmpty())){

                    if(pwd.matches(pwd_con) && (Patterns.EMAIL_ADDRESS.matcher(email).matches())){

                        mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener((Executor) DiscountFragment.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(!task.isSuccessful()){

                                    //Toast.makeText(MainActivity.this,"SignUp failed, please try again",Toast.LENGTH_SHORT).show();

                                }else{


                                    //startActivity(new Intent(MainActivity.this,Res_owner_dashboard.class));
                                    //Toast.makeText(MainActivity.this,"SignUp ok",Toast.LENGTH_SHORT).show();

                                    sendEmailVerification();

                                }
                            }
                        });
                    }
                    if(!pwd.matches(pwd_con)){

                        password_confm.setError("Password doesn't match");
                        password_confm.requestFocus();

                    }
                    if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                        emailID.setError("Please enter a valid email ID");
                        emailID.requestFocus();
                    }
                }
                else{

                    //Toast.makeText(MainActivity.this,"Error Occured",Toast.LENGTH_SHORT).show();
                }

            }
        });




        return view;
    }

    public void sendEmailVerification() {

        mFirebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful()){

                    //Toast.makeText(MainActivity.this,"Registration completed. Plsease check your email to verify account.",Toast.LENGTH_LONG).show();

                }
                else{

                    //Toast.makeText(MainActivity.this,"Error Occured",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}