package com.ssafy.accelometermusicplayer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.ssafy.accelometermusicplayer.R

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

        //target sdk 33 인 앱이 13버전인 기기에 설치되는 경우 Post notification 권한이 허용되어야 노티피케이션이 나타난다
        TedPermission.create()
            .setPermissionListener(permissionListener)
            .setDeniedMessage("알림 허용이 필요합니다!!")
            .setPermissions(android.Manifest.permission.POST_NOTIFICATIONS)
            .check()

    }
}