package com.example.retrofit.repository

import android.app.Application
import android.app.ProgressDialog
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.MemeModel
import com.example.retrofit.model.RetrofitModel
import com.example.retrofit.utils.CoinDeskInterface
import com.example.retrofit.utils.Retrofitinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRepository(application: Application) {
    var mDataValues = MutableLiveData<RetrofitModel>()
    var mDataFailer = MutableLiveData<String>()
    var fetchMemesSuccess = MutableLiveData<MemeModel>()
    var BASE_URL = "https://www.boredapi.com/api/"
    var MEME_URL = "https://meme-api.herokuapp.com/"
    fun fetchActivity() {
        //create a retrofit builder and pass our base URL
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
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

    // to fetch memes data
    fun fetchMemesData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(MEME_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // below line is to create an instance for our retrofit api class.
        val coinDeskInterface: CoinDeskInterface = retrofit.create(CoinDeskInterface::class.java)
        val call: Call<MemeModel> = coinDeskInterface.generateMeme()
        call.enqueue(object : Callback<MemeModel> {
            override fun onResponse(call: Call<MemeModel>, response: Response<MemeModel>) {
                val memeModel: MemeModel? = response.body()
                fetchMemesSuccess.value = memeModel
            }

            override fun onFailure(call: Call<MemeModel>, t: Throwable) {
                mDataFailer.value = call.toString()
            }

        })
    }

}