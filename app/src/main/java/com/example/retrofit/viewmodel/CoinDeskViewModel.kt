package com.example.retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.CoinDeskModel
import com.example.retrofit.model.CoinModel
import com.example.retrofit.repository.CoinDeskRepository

class CoinDeskViewModel(application: Application) : AndroidViewModel(application) {
    var coinDeskRepository = CoinDeskRepository(application)
    fun fetchData() {
        coinDeskRepository.getApiData()
    }

    fun mSuccessfulResponce(): MutableLiveData<ArrayList<CoinModel>> {
        return coinDeskRepository.mSuccessData
    }

    fun mOnFailureResponse(): MutableLiveData<String> {
        return coinDeskRepository.mFailureData
    }

}