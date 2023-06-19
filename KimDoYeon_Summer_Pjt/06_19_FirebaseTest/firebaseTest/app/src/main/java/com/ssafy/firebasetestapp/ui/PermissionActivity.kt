package com.ssafy.firebasetestapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.ssafy.firebasetestapp.R

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        val permissionListener : PermissionListener = object : PermissionListener{
            override fun onPermissionGranted() {
                val intent = Intent(this@PermissionActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(this@PermissionActivity, "허용안하면 앱 사용 못해요!!", Toast.LENGTH_SHORT).show()
            }

        }

        TedPermission.create()
            .setPermissionListener(permissionListener)
            .setRationaleMessage("허가좀 ㅋㅋ")
            .setDeniedMessage("허용이 필요합니다!!")
            .setPermissions(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            .check()

    }

}