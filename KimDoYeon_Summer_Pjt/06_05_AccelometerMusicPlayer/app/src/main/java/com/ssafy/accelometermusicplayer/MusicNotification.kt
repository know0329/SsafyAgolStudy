package com.ssafy.accelometermusicplayer

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.ssafy.accelometermusicplayer.ui.MainActivity


private const val TAG = "MusicNotification"
object MusicNotification {
    const val CHANNEL_ID = "shake_music_channel"

    fun createNotification(context: Context):Notification{
        // 알림 클릭시 MainActivity로 이동됨
        val notificationIntent = Intent(context, MainActivity::class.java)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(context,0,notificationIntent,PendingIntent.FLAG_IMMUTABLE)

        // 알림
        val notification =
            NotificationCompat.Builder(context, CHANNEL_ID).setContentTitle("Music Player")
                .setContentText("My Music").setSmallIcon(R.drawable.baseline_screen_rotation_24)
                .setOngoing(true) // true 일경우 알림 리스트에서 클릭하거나 좌우로 드래그해도 사라지지 않음
                .setContentIntent(pendingIntent)


        // Oreo 부터는 Notification Channel을 만들어야 함
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Music Player Channel", // 채널표시명
                NotificationManager.IMPORTANCE_LOW
            )
            val manager = context.getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
            Log.d(TAG, "createNotification: is null ${manager==null}")
        };return notification.build()
    }
}