package com.ssafy.accelometermusicplayer.ui

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ssafy.accelometermusicplayer.databinding.ActivityMainBinding
import com.ssafy.accelometermusicplayer.MusicService
import com.ssafy.accelometermusicplayer.ShakeListener
import com.ssafy.accelometermusicplayer.utils.Actions

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var accelometerSensor : Sensor
    private lateinit var sensorManager: SensorManager
    private lateinit var sensorEventListener: SensorEventListener
    private var musicState = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setMusicState()

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        accelometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorEventListener = ShakeListener().apply {
            setOnShakeListener(object : ShakeListener.OnShakeListener {
                override fun onShake() {
                    musicState=!musicState
                    setMusicState()
                }

            })
        }


    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(
            sensorEventListener,
            accelometerSensor,
            SensorManager.SENSOR_DELAY_UI
        )
    }

    fun setMusicState(){
        if(musicState==false){
            binding.tvMusicState.text="music off"
            val intent = Intent(this, MusicService::class.java)
            intent.action= Actions.STOP_MUSIC
            startService(intent)

        }else{
            binding.tvMusicState.text="music on"
            val intent = Intent(this, MusicService::class.java)
            intent.action= Actions.PLAY_MUSIC
            startService(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(sensorEventListener)
    }

}