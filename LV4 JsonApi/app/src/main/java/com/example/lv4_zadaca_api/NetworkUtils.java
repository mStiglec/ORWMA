package com.example.lv4_zadaca_api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkUtils {

    private static final String BASE_URL="https://makeup-api.herokuapp.com/api/v1/";
    private static APIInterface apiInterface;

    public static APIInterface getAPIInterface(){
        if(apiInterface==null){
            Retrofit retrofit = new Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    build();
            apiInterface = retrofit.create(APIInterface.class);
        }
        return apiInterface;
    }

}
