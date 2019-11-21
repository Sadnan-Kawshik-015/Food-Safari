package com.example.logintest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;

public class Entry_choice extends AppCompatActivity {

    Button btn_user,btn_res_owner;

    private int lastPosition=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_choice);

        btn_user = (Button) findViewById(R.id.button_user);
        btn_res_owner = (Button) findViewById(R.id.button_res_owner);

        setAnimation(btn_user,2);

        setAnimation(btn_res_owner,3);

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //startActivity(new Intent(Entry_choice.this,));
                startActivity(new Intent(Entry_choice.this,MainActivity.class));
                Constant.mood = "User";
            }
        });

        btn_res_owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Entry_choice.this,MainActivity.class));
                Constant.mood = "Restaurant_owner";

            }
        });
    }

    public void setAnimation(View viewToAnimate,int position)
    {
        if(position>lastPosition)
        {
            ScaleAnimation animation=new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,
                    Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

            animation.setDuration(1000);
            viewToAnimate.startAnimation(animation);
            lastPosition=position;
        }
    }
}
