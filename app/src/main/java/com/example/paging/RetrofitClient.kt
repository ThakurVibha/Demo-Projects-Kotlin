package com.example.paging

import com.google.android.gms.common.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient private constructor() {
    private val retrofit: Retrofit
    val api
        get() = retrofit.create(Api::class.java)

    companion object {
        private const val BASE_URL = "https://api.stackexchange.com/2.2/"
        private var mInstance: RetrofitClient? = null

        @get:Synchronized
        val instance: RetrofitClient?
            get() {
                if (mInstance == null) {
                    mInstance = RetrofitClient()
                }
                return mInstance
            }
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}