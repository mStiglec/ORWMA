package com.example.lv4_zadaca_api;


import androidx.annotation.NonNull;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("name")
    private String Name;
    @SerializedName("price")
    private Double Price;
    @SerializedName("rating")
    private Double Rating;
    @SerializedName("description")
    private String Description;
    @SerializedName("image_link")
    private String ImageLink;

    public String getName() {
        return Name;
    }

    public Double getPrice() {
        return Price;
    }

    public Double getRating() {
        return Rating;
    }

    public String getDescription() {
        return Description;
    }

    public String getImageLink() { return ImageLink; }
}
