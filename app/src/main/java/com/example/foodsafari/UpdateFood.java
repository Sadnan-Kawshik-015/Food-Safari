package com.example.logintest;

/*import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UpdateFood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_food);
    }
}
*/
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

public class UpdateFood extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    SwitchCompat switchCompat;
    EditText update_food_detail,updated_food_price;
    Button update_btn,updated_food,browse_food;
    TextView update_date;
    ImageView update_img;
    private Uri filePath;
    ProgressDialog progressDialog;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    String downloadImageUrl;
    int status;

    /**The update food class*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_food);

        //getSupportActionBar().setTitle("Add New Food");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        storageReference = FirebaseStorage.getInstance().getReference("Res_Owner_Images_MENU");
        databaseReference = FirebaseDatabase.getInstance().getReference("Res_owner_menu");
        progressDialog = new ProgressDialog(UpdateFood.this);
        switchCompat = findViewById(R.id.sw_btn_active_status);
        updated_food = findViewById(R.id.et_selected_food);
        browse_food = findViewById(R.id.et_selected_food2);
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
                    status = 1;
                    //will send status in database
                }
                else
                {
                    Toast.makeText(UpdateFood.this,"Status : OFF",Toast.LENGTH_SHORT).show();
                    status = 0;
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
                UploadImage();
                //changeActivity(Res_owner_dashboard.class);
            }
        });
        updated_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //chooseImage();
                startActivity(new Intent(UpdateFood.this,CaptureImage.class));
            }
        });
        browse_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseImage();
                //startActivity(new Intent(UpdateFood.this,CaptureImage.class));
            }
        });
    }

    private void chooseImage() {

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Image"),1);
        //startActivity(new Intent(UpdateFood.this,CaptureImage.class));

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

    public String GetFileExtension(Uri uri) {

        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri)) ;

    }

    public void UploadImage() {

        if (filePath != null) {

            progressDialog.setTitle("Image is Uploading...");
            progressDialog.show();
            final StorageReference storageReference2 = storageReference.child(System.currentTimeMillis() + "." + GetFileExtension(filePath));
            final UploadTask uploadTask = storageReference2.putFile(filePath);

            uploadTask
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            //String TempImageName = update_food_detail.getText().toString().trim();
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Image Uploaded Successfully ", Toast.LENGTH_LONG).show();

                            Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                                @Override
                                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception
                                {
                                        if (!task.isSuccessful())
                                        {
                                                throw task.getException();
                                        }

                                        downloadImageUrl = storageReference2.getDownloadUrl().toString();
                                        return storageReference2.getDownloadUrl();
                                 }
                            }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task)
                                {
                                    if (task.isSuccessful())
                                    {
                                        downloadImageUrl = task.getResult().toString();

                                        Toast.makeText(UpdateFood.this, "got the Product image Url Successfully...", Toast.LENGTH_SHORT).show();

                                        String TempImageName = update_food_detail.getText().toString().trim();
                                        int val_status = status;
                                        String price = updated_food_price.getText().toString().trim();
                                        String date = update_date.getText().toString().trim();

                                        Upload_Food upload = new Upload_Food(TempImageName,downloadImageUrl,val_status,price,date);
                                        String ImageUploadId = Constant.res_owner_pass;

                                        databaseReference.child(ImageUploadId).child(TempImageName).setValue(upload);

                                        //SaveProductInfoToDatabase();
                                    }
                                }
                            });

                            //@SuppressWarnings("VisibleForTests")
                            //uploadinfo imageUploadInfo = new uploadinfo(TempImageName, taskSnapshot.getUploadSessionUri().toString());
                            //String ImageUploadId = databaseReference.push().getKey();
                            //Upload upload = new Upload(TempImageName,taskSnapshot.getUploadSessionUri().toString());
                            //String ImageUploadId = Constant.res_owner_pass;
                            //databaseReference.child(ImageUploadId).setValue(upload);
                        }
                    });
        }
        else {

            Toast.makeText(UpdateFood.this, "Please Select Image or Add Image Name", Toast.LENGTH_LONG).show();

        }
    }



    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());

        update_date.setText(currentDateString);
    }


    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(this,destination);
        //intent.putExtra("Player Choice",result);
        startActivity(intent);
        finish();
    }

}