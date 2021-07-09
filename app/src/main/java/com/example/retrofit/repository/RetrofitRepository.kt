package com.example.retrofit.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.RetrofitModel
import com.example.retrofit.utils.Retrofitinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepository(application: Application) {
    var mDataValues = MutableLiveData<RetrofitModel>()
    var mDataFailer = MutableLiveData<String>()
//   var BASE_URL="https://www.boredapi.com/api/"
    var BASE_URL="https://www.boredapi.com/api/"

    fun fetchActivity() {
        //create a retrofit builder and pass our base URL
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // below line is to create an instance for our retrofit api class.
        val retrofitInterface: Retrofitinterface = retrofit.create(Retrofitinterface::class.java)
        val call: Call<RetrofitModel> = retrofitInterface.myActivity

        call.enqueue(object : Callback<RetrofitModel> {
            override fun onResponse(call: Call<RetrofitModel>, response: Response<RetrofitModel>) {

                if (response.isSuccessful()) {
                    val modal: RetrofitModel? = response.body()
                    mDataValues.value = modal
                }
            }
            override fun onFailure(call: Call<RetrofitModel>, t: Throwable) {
                mDataFailer.value = call.toString()
            }
        })
    }

}