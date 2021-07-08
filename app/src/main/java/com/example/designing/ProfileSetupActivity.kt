package com.example.designing

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.forlooptask.R
import dk.nodes.filepicker.FilePickerConstants
import dk.nodes.filepicker.uriHelper.FilePickerUriHelper
import kotlinx.android.synthetic.main.activity_image_picker.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_profile_setup.*

class ProfileSetupActivity : AppCompatActivity() {
    var REQUEST_CODE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setup)
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ); //enable full screen
        radio_group.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            Toast.makeText(
                applicationContext,
                " ${radio.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
        onClick()
    }


    private fun onClick() {
        galleryIv.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            Toast.makeText(
                this@ProfileSetupActivity,
                "Please Select a Picture",
                Toast.LENGTH_SHORT
            ).show()
            startActivityForResult(Intent.createChooser(intent, "Select picture"), REQUEST_CODE)
        }
        cameraIv.setOnClickListener {
            val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePicture, 5)
        }
        button.setOnClickListener {
            var id: Int = radio_group.checkedRadioButtonId
            if (id != -1) {
                val radio: RadioButton = findViewById(id)
                Toast.makeText(
                    applicationContext,
                    " ${radio.text}",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    applicationContext,
                    " nothing selected",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(
                    this@ProfileSetupActivity,
                    FilePickerUriHelper.getUriString(data!!),
                    Toast.LENGTH_SHORT
                ).show()
                profilePic.setImageURI(FilePickerUriHelper.getUri(data))
                //Glide loading with URI
                Glide.with(this).load(FilePickerUriHelper.getUri(data)).into(profilePic)
                //Imageview setImageUri with URI from File
                profilePic.setImageURI(Uri.fromFile(FilePickerUriHelper.getFile(this, data)))
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this@ProfileSetupActivity, "User Canceled", Toast.LENGTH_SHORT)
                    .show()
            } else if (resultCode == FilePickerConstants.RESULT_CODE_FAILURE) {
                Toast.makeText(this@ProfileSetupActivity, "Failed", Toast.LENGTH_SHORT).show()
            }

            if (requestCode == 5 && resultCode == RESULT_OK && data != null) {
                if (data != null) {
                    clickIv.setImageBitmap(data!!.getExtras()!!.get("data") as Bitmap)
                }
            }
        }

    }


}