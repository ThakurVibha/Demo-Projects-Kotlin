package com.example.retrofitfileuploader

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.forlooptask.R
import com.example.myfirstapp.Utils
import com.example.retrofit.utils.CoinDeskInterface
import com.example.retrofit.utils.MyInterceptor
import com.google.gson.JsonObject
import dk.nodes.filepicker.FilePickerConstants
import dk.nodes.filepicker.uriHelper.FilePickerUriHelper
import kotlinx.android.synthetic.main.activity_file_uploader.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FileUploaderActivity : AppCompatActivity() {
    val REQUEST_CODEE = 0
    val BASE_URL = "https://api.imgur.com/"
    val AUTH_KEY = "d76a7153e983213940780cbcc6f36621ec29b2aa"
    val BASE_URL2 = "https://jsonplaceholder.typicode.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_uploader)
//        pickImage.setOnClickListener {
//            old_method_pic_image()
//        }
        deletePost(id = Int)
    }

    private fun old_method_pic_image() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        Toast.makeText(
            this@FileUploaderActivity,
            "Please Select a Picture",
            Toast.LENGTH_SHORT
        ).show()
        startActivityForResult(Intent.createChooser(intent, "Select picture"), REQUEST_CODEE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(resultCode, resultCode, data)
        if (requestCode == REQUEST_CODEE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(
                    this@FileUploaderActivity,
                    FilePickerUriHelper.getUriString(data!!),
                    Toast.LENGTH_SHORT
                ).show()
                val uri = FilePickerUriHelper.getUri(data)
                uploadImage(uri)
                postImage.setImageURI(FilePickerUriHelper.getUri(data))
                //Glide loading with URI
                Glide.with(this).load(FilePickerUriHelper.getUri(data)).centerCrop()
                    .placeholder(R.drawable.bg_layout)
                    .into(postImage)
                //Imageview setImageUri with URI from File
                postImage.setImageURI(Uri.fromFile(FilePickerUriHelper.getFile(this, data)))
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this@FileUploaderActivity, "User Canceled", Toast.LENGTH_SHORT)
                    .show()
            } else if (resultCode == FilePickerConstants.RESULT_CODE_FAILURE) {
                Toast.makeText(this@FileUploaderActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun uploadImage(uri: Uri) {
        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .client(MyInterceptor().addInterceptro()).build()

        var coinDeskInterface: Api = retrofit.create(Api::class.java)

        val file = Utils.method4(this, uri = uri)

        val multipartBody = MultipartBody.Part.createFormData(
            "image",
            file!!.name,
            file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
        )
        coinDeskInterface.uploadImage(multipartBody).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                Log.e("//", "onResponse: ")
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("//", "onFailure: ")
            }

        })
    }

    //
//    fun uploadImage(view: View) {
//        var retrofit =
//            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
//                .build()
//        var coinDeskInterface: Api = retrofit.create(Api::class.java)
//        var call: Call<FileUploaderModel> = coinDeskInterface.uploadImage()
//        call.enqueue(object : Callback<FileUploaderModel> {
//            override fun onResponse(call: Call<FileUploaderModel>, response: Response<FileUploaderModel>) {
//                if (response.isSuccessful) {
//
//                }
//            }
//
//            override fun onFailure(call: Call<FileUploaderModel>, t: Throwable) {
//
//            }
//        })
//    }
    fun deletePost(id: Int.Companion) {
        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL2).addConverterFactory(GsonConverterFactory.create())
                .client(MyInterceptor().addInterceptro()).build()
        var coinDeskInterface: CoinDeskInterface = retrofit.create(CoinDeskInterface::class.java)
        coinDeskInterface.deletePost(id).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                Log.e("//", "onResponse: " + response.body()!!.asJsonObject.get("userId"))
            }
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("//", "onFailure: " + t.message)
            }

        })

    }


}

