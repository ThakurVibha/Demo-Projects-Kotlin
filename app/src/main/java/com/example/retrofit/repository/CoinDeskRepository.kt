package com.example.retrofit.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.utils.MyInterceptor
import com.example.retrofit.model.CoinModel
import com.example.retrofit.utils.CoinDeskInterface
import com.example.retrofitmovies.model.MoviesModelItem
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinDeskRepository(application: Application) {
    var mSuccessData = MutableLiveData<CoinModel>()
    var mFailureData = MutableLiveData<String>()
    var BASE_URL = "https://api.coindesk.com/v1/bpi/"
    var BASE_URL2 = "https://jsonplaceholder.typicode.com/"
    var list = ArrayList<CoinModel>()
    fun getApiData() {
        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        var coinDeskInterface: CoinDeskInterface = retrofit.create(CoinDeskInterface::class.java)
        var call: Call<ArrayList<CoinModel>> = coinDeskInterface.getMyActivity()
        call.enqueue(object : Callback<ArrayList<CoinModel>> {
            override fun onResponse(
                call: Call<ArrayList<CoinModel>>,
                response: Response<ArrayList<CoinModel>>
            ) {
                if (response.isSuccessful) {
                    val modal: ArrayList<CoinModel>? = response.body()
//                    mSuccessDatasData.value = modal
                }
            }

            override fun onFailure(call: Call<ArrayList<CoinModel>>, t: Throwable) {
                mFailureData.value = call.toString()

            }
        })


    }
}
//    fun postApiData() {
//        var retrofit =
//            Retrofit.Builder().baseUrl(BASE_URL2).addConverterFactory(GsonConverterFactory.create())
//                .build()
//        var coinDeskInterface: CoinDeskInterface = retrofit.create(CoinDeskInterface::class.java)
//        coinDeskInterface.postData2().enqueue(object : Callback<JsonObject> {
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                Log.e("//", "onResponse: " + response.body()!!.get("id"))
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                Log.e("//", "onFailure: " + t.message)
//            }
//
//        })
//    }

//    fun getSpeicificPost(id: Int) {
//        var retrofit =
//            Retrofit.Builder().baseUrl(BASE_URL2).addConverterFactory(GsonConverterFactory.create())
//                .client(MyInterceptor().addInterceptro())
//                .build()
//        var coinDeskInterface: CoinDeskInterface = retrofit.create(CoinDeskInterface::class.java)
//        coinDeskInterface.getSpecificPost(id).enqueue(object : Callback<JsonObject> {
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                Log.e("//", "onResponse: " + response.body()!!.asJsonObject.get("userId"))
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                Log.e("//", "onFailure: " + t.message)
//            }
//        })
//    }

//    fun deletePost(id: Int){
//        var retrofit=Retrofit.Builder().baseUrl(BASE_URL2).addConverterFactory(GsonConverterFactory.create()).client(MyInterceptor().addInterceptro()).build()
//        var coinDeskInterface:CoinDeskInterface=retrofit.create(CoinDeskInterface::class.java)
//        coinDeskInterface.deletePost(id).enqueue(object :Callback<JsonObject>{
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                Log.e("//", "onResponse: " + response.body()!!.asJsonObject.get("userId"))
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                Log.e("//", "onFailure: " + t.message)
//            }
//
//        })
//
//    }
