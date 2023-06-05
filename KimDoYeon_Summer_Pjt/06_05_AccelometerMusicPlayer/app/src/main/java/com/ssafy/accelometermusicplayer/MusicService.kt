package com.ssafy.accelometermusicplayer

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import com.ssafy.accelometermusicplayer.utils.Actions

class MusicService : Service(){
    lateinit var mp: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mp = MediaPlayer.create(this, R.raw.music)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Actions.PLAY_MUSIC ->{
                if(!mp.isPlaying){
                    mp.isLooping=true
                    mp.start()
                    startForegroundService()
                }
            }

            Actions.STOP_MUSIC->{
                if(mp.isPlaying){
                    mp.stop()
                    stopForegroundService()
                }
            }
        }
        return START_STICKY
    }

    private fun startForegroundService() {
        val notification = MusicNotification.createNotification(this)
        startForeground(NOTIFICATION_ID, notification)
    }

    private fun stopForegroundService() {
        stopForeground(true)
        stopSelf()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    companion object {
        const val NOTIFICATION_ID = 20
    }
}