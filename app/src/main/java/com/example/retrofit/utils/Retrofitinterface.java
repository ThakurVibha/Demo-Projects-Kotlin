package com.example.retrofit.utils;

import com.example.retrofit.model.RetrofitModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofitinterface {
    @GET("activity")
    Call<RetrofitModel> getMyActivity();

}