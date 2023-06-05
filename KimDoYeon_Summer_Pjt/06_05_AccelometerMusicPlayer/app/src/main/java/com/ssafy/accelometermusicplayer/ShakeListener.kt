package com.ssafy.accelometermusicplayer

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log

private const val TAG = "ShackeListener"

class ShakeListener : SensorEventListener{
    private var mShakeTime : Long= 0L
    private val SHAKE_SKIP_TIME=500
    private val SHAKE_THRESHOLD_GRAVITY = 2.7F
    private lateinit var mListener: OnShakeListener

    fun setOnShakeListener(listener: OnShakeListener){
        mListener = listener
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        if(p0!=null){
            val axisX=p0.values[0]
            val axisY=p0.values[1]
            val axisZ=p0.values[2]

            val gravityX = axisX/SensorManager.GRAVITY_EARTH
            val gravityY = axisY/SensorManager.GRAVITY_EARTH
            val gravityZ = axisZ/SensorManager.GRAVITY_EARTH

            val f = gravityX*gravityX + gravityY*gravityY + gravityZ*gravityZ
            val squaredD = Math.sqrt(f.toDouble())
            val gForce = squaredD.toFloat()

            if(gForce>SHAKE_THRESHOLD_GRAVITY){
                val currentTime= System.currentTimeMillis()
                if(mShakeTime+SHAKE_SKIP_TIME>currentTime){
                    Log.d(TAG, "onSensorChanged: 실행안됨")
                    return
                }
                mShakeTime=currentTime
                mShakeTime++
                Log.d(TAG, "onSensorChanged: Shake 발생!! $mShakeTime")
                mListener.onShake()
            }

        }
        
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    interface OnShakeListener{
        fun onShake()
    }

}