package com.example.logintest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

/*Adapter class for every menu item after the restaurant list**/

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder>{

    private Context mContext;
    private List<FoodData>myFoodList;/**List that contains item type of Food*/
    private int lastPosition=-1;


    public FoodAdapter(Context mContext, List<FoodData> myFoodList) {
        this.mContext = mContext;
        this.myFoodList = myFoodList;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_menu_row,parent,false);

        return new FoodViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder,final int position) {

        /**Used to set the values in the menu item template. Each menu item wil be stored under restaurants.Layout file for this
         * is recyler_menu_row.You can give suggestion if any change to suggest.**/

        //holder.menU_img.setImageResource(myFoodList.get(position).getFoodImage());
        Picasso.get().load(myFoodList.get(position).getFoodImage()).placeholder(R.drawable.logo).fit().centerCrop().into(holder.menU_img);
        holder.menu_title.setText(myFoodList.get(position).getFoodName());
        holder.menu_description.setText(myFoodList.get(position).getFoodDetails());
        holder.menu_price.setText(myFoodList.get(position).getFoodPrice()+" TK");
        holder.menu_status.setText(myFoodList.get(position).getActiveStatus());

        holder.menu_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(mContext,CartDetails.class);
                intent.putExtra("Food_img",myFoodList.get(position).getFoodImage());
                intent.putExtra("Food_name",myFoodList.get(position).getFoodName());
                intent.putExtra("Food_Details",myFoodList.get(position).getFoodDetails());
                intent.putExtra("Food_res_name",myFoodList.get(position).getRestaurantName());
                intent.putExtra("Food_price",myFoodList.get(position).getFoodPrice());
                intent.putExtra("Food_status",myFoodList.get(position).getActiveStatus());
                //intent.putExtra("FoodItem",myFoodList.get(position));
                mContext.startActivity(intent);

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


class FoodViewHolder extends RecyclerView.ViewHolder {

    /**Used to hold the view for the recyler_menu_row which is how every menu item will look like**/
    ImageView menU_img;
    TextView menu_title,menu_description,menu_price,menu_status;
    CardView menu_card;
    public FoodViewHolder( View itemView) {
        super(itemView);

        menU_img=itemView.findViewById(R.id.iv_food_item);
        menu_title=itemView.findViewById(R.id.tv_item_title);
        menu_description=itemView.findViewById(R.id.tv_item_details);
        menu_price=itemView.findViewById(R.id.tv_item_price2);
        menu_status=itemView.findViewById(R.id.tv_item_status2);
        menu_card=itemView.findViewById(R.id.cv_menu_details);
    }
}
