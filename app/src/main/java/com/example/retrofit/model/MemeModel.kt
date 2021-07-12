package com.example.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MemeModel {
    @SerializedName("url")
    @Expose
    var meme:String=""
}