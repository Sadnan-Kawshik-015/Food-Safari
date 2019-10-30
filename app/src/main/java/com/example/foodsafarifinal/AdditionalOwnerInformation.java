package com.example.foodsafarifinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class AdditionalOwnerInformation extends AppCompatActivity {

    EditText restaurant_name,restaurant_location;
    Button update_btn;
    ImageView owner_image;
    private Uri filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional_owner_information);

        getSupportActionBar().setTitle("Add User Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        restaurant_name=findViewById(R.id.et_owner_restaurant_name);
        restaurant_location=findViewById(R.id.et_owner_restaurant_location);
        update_btn=findViewById(R.id. btn_update_owner_info);
        owner_image=findViewById(R.id.iv_select_owner_image);
        owner_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**Do the data base portion*/
                changeActivity(RestaurantDashboard.class);
            }
        });
    }
    private void chooseImage() {

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Image"),1);

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            filePath=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                owner_image.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(this,destination);
        //intent.putExtra("Player Choice",result);
        startActivity(intent);
        finish();
    }
}
