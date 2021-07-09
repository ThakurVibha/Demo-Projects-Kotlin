package com.example.retrofit.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.CoinDeskModel
import com.example.retrofit.model.CoinModel
import com.example.retrofit.model.RetrofitModel
import com.example.retrofit.utils.CoinDeskInterface
import com.example.retrofit.utils.Retrofitinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoinDeskRepository(application: Application) {
    var mSuccessData = MutableLiveData<ArrayList<CoinModel>>()
    var mFailureData = MutableLiveData<String>()
    var BASE_URL="https://www.boredapi.com/api/"


    fun getApiData() {
        var retrofit = Retrofit.Builder().baseUrl(BASE_URL).build()
        var coinDeskInterface: CoinDeskInterface = retrofit.create(CoinDeskInterface::class.java)
        val call: Call<RetrofitModel?> = coinDeskInterface.getMyActivity()
        call.enqueue(object : Callback<RetrofitModel?> {
            override fun onResponse(
                call: Call<RetrofitModel?>, response: Response<RetrofitModel?>
            ) {
                if (response.isSuccessful) {
//                    val modal: ArrayList<RetrofitModel?> = response.body()
//                    mSuccessData.value = modal
                }
            }

            override fun onFailure(call: Call<RetrofitModel?>, t: Throwable) {
                mFailureData.value = call.toString()
            }
        })
    }
}