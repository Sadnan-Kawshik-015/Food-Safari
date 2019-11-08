package com.example.foodsafari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class userProfile extends AppCompatActivity implements View.OnClickListener {


    private TextView historytextView;
    private Button passwordChangeButton;
    private Button updateButton;

    private EditText userNameEditText;
    private EditText userEmailEditText;
    private EditText userPhnoEditText;




    private String name;
    private String email;
    private String phno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        userNameEditText = findViewById(R.id.userProfileNameEditText);
        userEmailEditText = findViewById(R.id.userEmailEditText);
        userPhnoEditText = findViewById(R.id.userPhnoEditText);

        passwordChangeButton = findViewById(R.id.userPasswordChangeButton);
        updateButton = findViewById(R.id.button2);
        historytextView = findViewById(R.id.userHistoryTextView);


    }

    @Override
    public void onClick(View v){

        switch(v.getId()){

            case R.id.userPasswordChangeButton:

                Intent intent = new Intent(getApplicationContext(),userPasswordChange.class);
                startActivity(intent);

                break;




//button2 is update button
            case R.id.button2:

                //updates all the fields except email

                name = userNameEditText.getText().toString();
                phno = userPhnoEditText.getText().toString();
                email = userEmailEditText.getText().toString();



                //firebase related works to update the fields





                Toast.makeText(userProfile.this,"Your Update is done",Toast.LENGTH_SHORT).show();

                //take to new activity or whatever else

                break;






    //here the page is directed to my cart but later on will be directed to sadnan kaushiks my orders

            case R.id.userHistoryTextView:

                Intent intent1 = new Intent(getApplicationContext(),customerOrderList.class);
                startActivity(intent1);


                break;




        }

    }
}
