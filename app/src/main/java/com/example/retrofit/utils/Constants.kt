package com.example.retrofit.utils

import retrofit2.Retrofit

class Constants {
var retrofit:Retrofit?=null
    var BASE_URL =
        "https://api.coindesk.com/v1/bpi/"
    fun getRestClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build()
        }
        return retrofit!!
    }
}