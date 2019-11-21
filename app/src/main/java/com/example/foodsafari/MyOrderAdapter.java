package com.example.logintest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderViewHolder>{
    private Context mContext;
    private List<FoodData> myFoodList;/**List that contains item type of Food*/
    private int lastPosition=-1;


    public MyOrderAdapter(Context mContext, List<FoodData> myFoodList) {
        this.mContext = mContext;
        this.myFoodList = myFoodList;
    }
    @NonNull
    @Override
    public MyOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_my_order_row,parent,false);
        return new MyOrderViewHolder(mView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderViewHolder holder, int position) {

        holder.item_img.setImageResource(myFoodList.get(position).getImg());
        holder.item_title.setText(myFoodList.get(position).getFoodName());
        holder.item_description.setText(myFoodList.get(position).getFoodDetails());
        holder.item_price.setText(myFoodList.get(position).getFoodPrice());
        holder.item_reorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Ordered Again",Toast.LENGTH_SHORT).show();
            }
        });
        setAnimation(holder.itemView,position);

    }
    public void setAnimation(View viewToAnimate,int position)
    {
        if (position>lastPosition)
        {
            ScaleAnimation scaleAnimation=new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,
                    Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

            scaleAnimation.setDuration(1000);
            viewToAnimate.startAnimation(scaleAnimation);
            lastPosition=position;
        }
    }
    @Override
    public int getItemCount() {
        return myFoodList.size();
    }
}
class MyOrderViewHolder extends RecyclerView.ViewHolder {

    /**Used to hold the view for the recyler_menu_row which is how every menu item will look like**/
    ImageView item_img;
    TextView item_title,item_description,item_price;
    CardView item_card;
    Button item_reorder;
    public MyOrderViewHolder( View itemView) {
        super(itemView);

        item_img=itemView.findViewById(R.id.iv_my_order_item_image);
        item_title=itemView.findViewById(R.id.tv_my_order_menu_item_title);
        item_description=itemView.findViewById(R.id.tv_my_order_menu_item_description);
        item_price=itemView.findViewById(R.id.tv_my_order_menu_item_price);
        item_card=itemView.findViewById(R.id.cv_my_orders_details);
        item_reorder=itemView.findViewById(R.id.btn_my_order_menu_item_reorder);
    }
}
