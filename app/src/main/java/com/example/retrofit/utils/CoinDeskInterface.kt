package com.example.retrofit.utils

import com.example.retrofit.model.CoinModel
import com.example.retrofit.model.MemeModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CoinDeskInterface {
    @GET("currentprice.json")
    fun getMyActivity(): Call<List<CoinModel>>
    @POST("name")
    fun postData():Call<CoinModel>

    @POST("/posts")
    fun postData2():Call<JsonObject>

    @GET("/posts/1")
    fun getSpecificPost(@Query("id") id :Int ):Call<JsonObject>

    @DELETE("/posts/1")
    fun deletePost(@Query("userId") id: Int.Companion):Call<JsonObject>
    
    //Meme generator api
    @GET("gimme")
    fun generateMeme():Call<MemeModel>


}