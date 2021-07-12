package com.example.retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.CoinModel
import com.example.retrofit.model.MemeModel
import com.example.retrofit.repository.CoinDeskRepository

class CoinDeskViewModel(application: Application) : AndroidViewModel(application) {
    var coinDeskRepository = CoinDeskRepository(application)
//    fun fetchData() {
//        coinDeskRepository.getApiData()
//    }

//    fun fetchPostRequest(){
//        coinDeskRepository.postApiData()
//    }
//    fun deletePost(i: Int) {
//        coinDeskRepository.deletePost(i)
//    }

    fun getSpecificPost(id:Int) = coinDeskRepository.getSpeicificPost(id)

    fun mSuccessfulResponce(): MutableLiveData<CoinModel> {
        return coinDeskRepository.mSuccessData
    }

    fun mOnFailureResponse(): MutableLiveData<String> {
        return coinDeskRepository.mFailureData
    }




//    fun postData(text: String) {
//        coinDeskRepository.postApiData()
//    }

}