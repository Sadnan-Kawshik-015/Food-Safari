package com.example.foodsafarifinal;

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

public class OwnerMenuAdapter extends RecyclerView.Adapter<OwnerMenuViewHolder> {

    private Context mContext;
    private List<FoodData> myFoodList;/**List that contains item type of Food*/
    private int lastPosition=-1;

    public OwnerMenuAdapter(Context mContext, List<FoodData> myFoodList) {
        this.mContext = mContext;
        this.myFoodList = myFoodList;
    }

    @NonNull
    @Override
    public OwnerMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View mView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_owner_menu,parent,false);
        return new OwnerMenuViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull OwnerMenuViewHolder holder, int position) {

        holder.item_img.setImageResource(myFoodList.get(position).getFoodImage());
        holder.item_title.setText(myFoodList.get(position).getFoodName());
        holder.item_description.setText(myFoodList.get(position).getFoodDetails());
        holder.item_price.setText(myFoodList.get(position).getFoodPrice());
        holder.item_delete.setOnClickListener(new View.OnClickListener() {
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
        return 0;
    }
}

class OwnerMenuViewHolder  extends RecyclerView.ViewHolder {

    /**
     * Used to hold the view for the recyler_menu_row which is how every menu item will look like
     **/
    ImageView item_img;
    TextView item_title, item_description, item_price;
    CardView item_card;
    Button item_delete;

    public OwnerMenuViewHolder(View itemView) {
        super(itemView);

        item_img = itemView.findViewById(R.id.iv_owner_menu_image);
        item_title = itemView.findViewById(R.id.tv_owner_menu_food_name);
        item_description = itemView.findViewById(R.id.tv_owner_menu_food_description);
        item_price = itemView.findViewById(R.id.tv_owner_menu_food_price);
        item_card = itemView.findViewById(R.id.tv_owner_menu_food_price);
        item_delete = itemView.findViewById(R.id.btn_owner_menu_food_delete);
    }
}
