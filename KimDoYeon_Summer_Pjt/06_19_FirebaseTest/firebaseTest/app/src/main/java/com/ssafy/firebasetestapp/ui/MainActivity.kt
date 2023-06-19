package com.ssafy.firebasetestapp.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.ssafy.firebasetestapp.R
import com.ssafy.firebasetestapp.data.Test
import com.ssafy.firebasetestapp.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var setImageButton : Button
    lateinit var saveButton: Button
    lateinit var contentEditText: EditText
    lateinit var moveButton : Button
    var uri : Uri? = null
    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = MainViewModel()

        setImageButton=findViewById(R.id.setImageButton)
        saveButton=findViewById(R.id.saveButton)
        contentEditText=findViewById(R.id.contentEditText)
        moveButton=findViewById(R.id.moveButton)


        setImageButton.setOnClickListener {
            requestGalleryImageLauncher.launch("image/*")
        }

        saveButton.setOnClickListener {
            if(contentEditText.text.toString()==""){
                Toast.makeText(this, "내용을 채우세요", Toast.LENGTH_SHORT).show()
            }else if(uri==null){
                Toast.makeText(this, "이미지 있어야됩니다", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.insert(Test("0", "", contentEditText.text.toString()), uri!!)
            }
        }

        moveButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ListActivity::class.java)
            startActivity(intent)
        }
    }


    private val requestGalleryImageLauncher=registerForActivityResult(
        ActivityResultContracts.GetContent()
    ){
        if(it!=null){
            uri = it
            Glide
                .with(this)
                .load(it.toString())
                .fitCenter()
                .into(findViewById(R.id.imageView))
        }
    }
}