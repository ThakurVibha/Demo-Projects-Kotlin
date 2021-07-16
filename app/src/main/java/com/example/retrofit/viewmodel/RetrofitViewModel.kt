package com.example.retrofit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.retrofit.model.MemeModel
import com.example.retrofit.model.RetrofitModel
import com.example.retrofit.repository.RetrofitRepository

class RetrofitViewModel(application: Application) : AndroidViewModel(application) {
    var repo = RetrofitRepository(application)

    fun fetchData() {
        repo.fetchActivity()
    }

    fun mSuccessfulResponce(): MutableLiveData<RetrofitModel> {
        return repo.mDataValues;
    }

    fun mOnFailureResponce(): MutableLiveData<RetrofitModel> {
        return repo.mDataValues
    }

    fun fetchMemes() {
        repo.fetchMemesData()
    }
    fun onFechingMemes():MutableLiveData<MemeModel>{
        return repo.fetchMemesSuccess
    }


}