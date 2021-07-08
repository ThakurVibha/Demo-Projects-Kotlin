package com.example.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RetrofitModel {
    @SerializedName("activity")
    @Expose
    var myActivity:String=""
    @SerializedName("type")
    @Expose
    var type:String=""
    @SerializedName("participants")
    @Expose
    var participants:String=""
}