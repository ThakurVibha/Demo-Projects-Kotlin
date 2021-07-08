package com.example.retrofit.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.forlooptask.R
import com.example.retrofit.model.RetrofitModel
import com.example.retrofit.utils.Retrofitinterface
import com.example.retrofit.viewmodel.RetrofitViewModel
import kotlinx.android.synthetic.main.activity_retrofit.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    lateinit var retrofitViewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        retrofitViewModel = ViewModelProvider(this).get(RetrofitViewModel::class.java)
        getMyActivity()
        onClick()
    }

    private fun onClick() {
        refreshBtn.setOnClickListener {
            getMyActivity()
        }
    }

    private fun getMyActivity() {
        //create a retrofit builder and pass our base URL
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // below line is to create an instance for our retrofit api class.
        val retrofitInterface: Retrofitinterface = retrofit.create(
            Retrofitinterface::class.java
        )
        val call: Call<RetrofitModel> = retrofitInterface.myActivity

        call.enqueue(object : Callback<RetrofitModel> {
            override fun onResponse(call: Call<RetrofitModel>, response: Response<RetrofitModel>) {

                if (response.isSuccessful()) {
                    val modal: RetrofitModel? = response.body()
                    tvActivity.setText(modal!!.myActivity)
                    tvType.setText(modal.type)
                    tvParticipents.setText(modal.participants)
                }
            }

            override fun onFailure(call: Call<RetrofitModel>, t: Throwable) {
                Toast.makeText(applicationContext, "fail to get data ", Toast.LENGTH_LONG).show()
            }


        })
    }
}





