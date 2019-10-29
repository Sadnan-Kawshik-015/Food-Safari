package com.example.foodsafarifinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

public class UpdateFood extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    SwitchCompat switchCompat;
    EditText updated_food,update_food_detail,updated_food_price;
    Button update_btn;
    TextView update_date;
    ImageView update_img;
    private Uri filePath;
    /**The update food class*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_food);

        getSupportActionBar().setTitle("Add New Food");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switchCompat = findViewById(R.id.sw_btn_active_status);
        updated_food = findViewById(R.id.et_selected_food);
        update_btn = findViewById(R.id.btn_update_food);
        update_date=findViewById(R.id.tv_update_food_date);
        update_food_detail=findViewById(R.id.et_selected_food_details);
        updated_food_price=findViewById(R.id.et_selected_food_price);
        update_img=findViewById(R.id.iv_select_image);
        switchCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(switchCompat.isChecked())
                {
                    Toast.makeText(UpdateFood.this,"Status : ON",Toast.LENGTH_SHORT).show();
                    //will send status in database
                }
                else
                {
                    Toast.makeText(UpdateFood.this,"Status : OFF",Toast.LENGTH_SHORT).show();
                    //will send status in database

                }
            }
        });

        update_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker=new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**Do the database portion*/
                changeActivity(RestaurantDashboard.class);
            }
        });
        update_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
            }
        });
    }

    private void chooseImage() {

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Image"),1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null)
        {
            filePath=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                update_img.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        update_date.setText("Date Set As : "+currentDateString);
    }
    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(this,destination);
        //intent.putExtra("Player Choice",result);
        startActivity(intent);
        finish();
    }
}
