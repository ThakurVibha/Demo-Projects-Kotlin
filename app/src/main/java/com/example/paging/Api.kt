package com.example.paging

import com.example.paging.model.StackApiResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("answers")
    fun getAnswers(@Query("page") page:Int, @Query("pagesize")  pagesize:Int, @Query("site") site:String ):Call<StackApiResponse>
}