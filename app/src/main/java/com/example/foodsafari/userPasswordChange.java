package com.example.foodsafari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class userPasswordChange extends AppCompatActivity implements View.OnClickListener {

    private Button confirmButton;

    private EditText newPasswordEditText1;
    private  EditText newPasswordEditText2;

    private String newPassword1;
    private String newPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_password_change);

        newPasswordEditText1 = findViewById(R.id.editText4);
        newPasswordEditText2 = findViewById(R.id.editText5);

        confirmButton = findViewById(R.id.passwordChangeButton);



    }

    @Override
    public  void onClick(View v){

        switch (v.getId()){
            case R.id.passwordChangeButton:

                newPassword1 = newPasswordEditText1.getText().toString();
                newPassword2 = newPasswordEditText2.getText().toString();

                if(newPasswordEditText1.isEmpty() || newPasswordEditText2.isEmpty()){
                Toast.makeText(userPasswordChange.this,"Please give your Password",Toast.LENGTH_SHORT).show();
            }

                else if(!newPasswordEditText1.equals(newPasswordEditText2)){
                    Toast.makeText(userPasswordChange.this,"Passwords didn't match\n Try again",Toast.LENGTH_SHORT).show();
                }




                else{

                    //firebase related work to update the user password

                    Toast.makeText(userPasswordChange.this,"Your Password is updated",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),userProfile.class);
                    startActivity(intent);
                }




                break;



        }

    }
}
