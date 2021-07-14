package com.example.retrofitfileuploader

import com.google.gson.JsonObject
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*


interface Api {
    //In order to POST a file, we need to enable Multipart.
    //Part define a part inside the Multipart. MultipartBody.Part is the type that we want to use for a file
    // image. Non-file Part should use RequestBody type with expected fieldname.

    @POST("3/image")
    fun uploadImage(@Header("Authorization") key:String): Call<FileUploaderModel>

    @Headers("Authorization: Bearer d76a7153e983213940780cbcc6f36621ec29b2aa")
    @Multipart
    @POST("3/image")
    fun uploadImage(@Part() image: MultipartBody.Part?) : Call<JsonObject>

    @GET("3/image")
    fun getImages(): Call<FileUploaderModel>

    //new
    @GET("gists")
    fun get(): Call<JsonObject>

    @POST("gists")
    fun post(): Call<JsonObject>

    // delete Gist
    @DELETE("/posts/1")
    fun delete(@Path("id") id: Int): Call<JsonObject?>?

//    @PATCH("gists/{id}")
//    fun patch():Call<JsonObject>
//
//    @PUT("gists/{id}")
//    fun put(@PATCH("id" )id:String, @Body gists:Gis):Call<JsonObject>



}