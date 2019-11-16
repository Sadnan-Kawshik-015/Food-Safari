package com.example.foodsafarifinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**Adapter for restaurant item you will get this check foodadapter for detail help**/

public class MyAdopter  extends RecyclerView.Adapter<RestaurantViewHolder> implements Filterable {

    private Context resContext;
    private List<RestaurantData> restaurantList;
    private List<RestaurantData>restaurantListFull;
    private int lastPosition=-1;

    public MyAdopter(Context resContext, List<RestaurantData> restaurantList) {
        this.resContext = resContext;
        this.restaurantList = restaurantList;
        restaurantListFull=new ArrayList<>(restaurantList);
    }

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View resView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_row_item,parent,false);

        return new RestaurantViewHolder(resView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RestaurantViewHolder holder, int position) {

        holder.imageView.setImageResource(restaurantList.get(position).getRestaurantImage());
        holder.resTitle.setText(restaurantList.get(position).getRestaurantName());
        holder.resDiscount.setText(restaurantList.get(position).getDiscount());
        holder.resCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(resContext,RestaurantMenu.class);
                intent.putExtra("RestaurantName",holder.resTitle.getText().toString());
                resContext.startActivity(intent);
            }
        });

        setAnimation(holder.itemView,position);
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

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    @Override
    public Filter getFilter() {

        return restaurantFilter;
    }
    private Filter restaurantFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<RestaurantData> filteredList=new ArrayList<>();

            if (charSequence == null||charSequence.length() == 0)
            {
                filteredList.addAll(restaurantListFull);
            }

            else
            {
                String filterPattern=charSequence.toString().toLowerCase().trim();

                for (RestaurantData item:restaurantListFull)
                {
                    if (item.getRestaurantName().toLowerCase().contains(filterPattern))
                    {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

            restaurantList.clear();
            restaurantList.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

}


class RestaurantViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView resTitle,resDiscount;
    CardView resCardview;

    public RestaurantViewHolder(View itemView) {

        super(itemView);

        imageView=itemView.findViewById(R.id.iv_restaurant_image);
        resTitle=itemView.findViewById(R.id.tv_title);
        resDiscount=itemView.findViewById(R.id.tv_discount);
        resCardview=itemView.findViewById(R.id.cv_restaurant_details);

    }

}