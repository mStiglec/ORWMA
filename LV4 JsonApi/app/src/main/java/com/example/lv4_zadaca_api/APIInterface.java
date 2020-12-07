package com.example.lv4_zadaca_api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    @GET("products.json")
    Call<List<Product>> getAllProducts();

    @GET("products.json")
    Call<List<Product>> getProductsByBrand(@Query("brand") String brand);

}
