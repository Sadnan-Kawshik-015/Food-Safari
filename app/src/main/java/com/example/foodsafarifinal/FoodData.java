package com.example.foodsafarifinal;


import android.os.Parcel;
import android.os.Parcelable;

/**This class contains all menu item characteristics**/

public class FoodData implements Parcelable {

    private String foodName;
    private String foodDetails;
    private String foodPrice;
    private int foodImage;
    private String activeStatus;

    public FoodData(String foodName, String foodDetails, String foodPrice, int foodImage, String activeStatus) {
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.activeStatus = activeStatus;
    }
    public FoodData(String foodName, String foodDetails, String foodPrice, int foodImage) {
        this.foodName = foodName;
        this.foodDetails = foodDetails;
        this.foodPrice = foodPrice;
        this.foodImage = foodImage;
        this.activeStatus="Active";
    }


    protected FoodData(Parcel in) {
        foodName = in.readString();
        foodDetails = in.readString();
        foodPrice = in.readString();
        foodImage = in.readInt();
        activeStatus = in.readString();
    }

    public static final Creator<FoodData> CREATOR = new Creator<FoodData>() {
        @Override
        public FoodData createFromParcel(Parcel in) {
            return new FoodData(in);
        }

        @Override
        public FoodData[] newArray(int size) {
            return new FoodData[size];
        }
    };

    public String getFoodName() {
        return foodName;
    }

    public String getFoodDetails() {
        return foodDetails;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(foodName);
        parcel.writeString(foodDetails);
        parcel.writeString(foodPrice);
        parcel.writeInt(foodImage);
        parcel.writeString(activeStatus);
    }
}
