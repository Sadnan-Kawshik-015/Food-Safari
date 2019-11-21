package com.example.logintest;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyCart extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CartProduct>myCartList;
    CartProduct mCartProduct;
    TextView totalPrice;
    Button orderNext;
    int total_price=0;

    private DatabaseReference mDatabaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        //getSupportActionBar().setTitle("My Cart");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView=findViewById(R.id.rv_my_cart);
        totalPrice=findViewById(R.id.tv_total_price_cart);
        orderNext=findViewById(R.id.btn_order_next);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(MyCart.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        myCartList=new ArrayList<>();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("User_Order").child(Constant.user_pass_);


        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    CartProduct upload = postSnapshot.getValue(CartProduct.class);


                    myCartList.add(upload);

                    for (int i=0;i<myCartList.size();i++)
                    {
                        total_price=total_price+(Integer.parseInt(myCartList.get(i).getFoodPrice())*myCartList.get(i).getQuantity());
                    }

                    totalPrice.setText("Total = "+Integer.toString(total_price)+" Tk");
                    Constant.cost = Integer.toString(total_price);

                    CartItemAdapter cartItemAdapter=new CartItemAdapter(MyCart.this,myCartList);
                    recyclerView.setAdapter(cartItemAdapter);



                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                System.out.println("Error");
                //Toast.makeText(MenuFragment.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                //mProgressCircle.setVisibility(View.INVISIBLE);
            }

        });




        orderNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(OrderFinalization.class);
            }
        });
    }
    public void changeActivity(Class destination)
    {
        Intent intent=new Intent(this,destination);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent(MyCart.this,UserNewsFeed.class);
        startActivity(i);

    }
}

