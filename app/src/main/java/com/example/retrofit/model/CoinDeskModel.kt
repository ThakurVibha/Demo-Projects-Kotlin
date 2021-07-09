package com.example.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CoinDeskModel {
    @SerializedName("code")
    @Expose
    var code:String=""
    @SerializedName("symbol")
    @Expose()
    var symbol:String=""
    @SerializedName("rate")
    @Expose()
    var rate:String=""
    @SerializedName("description")
    @Expose()
    var description:String=""
}