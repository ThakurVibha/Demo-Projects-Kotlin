package com.example.filepicker

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.forlooptask.R
import dk.nodes.filepicker.FilePickerConstants.RESULT_CODE_FAILURE
import dk.nodes.filepicker.uriHelper.FilePickerUriHelper
import kotlinx.android.synthetic.main.activity_image_picker.*


class ImagePickerActivity : AppCompatActivity() {
    val REQUEST_CODE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_picker)
        onClick()
    }

    // to start gallery intent
    private fun onClick() {
        chooseIvBtn.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            Toast.makeText(
                this@ImagePickerActivity,
                "Please Select a Picture",
                Toast.LENGTH_SHORT
            ).show()
            startActivityForResult(Intent.createChooser(intent, "Select picture"), REQUEST_CODE)
        }
        clickBtn.setOnClickListener {
            val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePicture, 5)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this@ImagePickerActivity, FilePickerUriHelper.getUriString(data!!), Toast.LENGTH_SHORT
                ).show()
                clickIv.setImageURI(FilePickerUriHelper.getUri(data))
                //Glide loading with URI
                Glide.with(this).load(FilePickerUriHelper.getUri(data)).centerCrop().placeholder(R.drawable.bg_layout)
                    .into(clickIv)
                //Imageview setImageUri with URI from File
                clickIv.setImageURI(Uri.fromFile(FilePickerUriHelper.getFile(this, data)))
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this@ImagePickerActivity, "User Canceled", Toast.LENGTH_SHORT)
                    .show()
            } else if (resultCode == RESULT_CODE_FAILURE) {
                Toast.makeText(this@ImagePickerActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
        if (requestCode == 5 && resultCode ==RESULT_OK && data != null) {
            if (data != null) {
                clickIv.setImageBitmap(data!!.getExtras()!!.get("data") as Bitmap)
            }
        }
    }
}
