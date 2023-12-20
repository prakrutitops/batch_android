package com.example.sensorex

import android.annotation.SuppressLint
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(),SensorEventListener
{
    lateinit var txt1:TextView
    lateinit var sensorManager: SensorManager
    var lastUpdate: Long = 0
    private var color = false
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt1 = findViewById(R.id.txt1)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        txt1.setBackgroundColor(Color.GREEN)
        lastUpdate = System.currentTimeMillis()

    }

    override fun onSensorChanged(event: SensorEvent?)
    {
        if (event!!.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            getAccelerometer(event)
        }
    }

    private fun getAccelerometer(event: SensorEvent)
    {
        val values = event.values

        var x: Float = values.get(0)
        var y: Float = values.get(1)
        var z: Float = values.get(2)

        val accelationSquareRoot = ((x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH))


        val actualTime = event.timestamp

        if (accelationSquareRoot >= 2) {
            if (actualTime - lastUpdate < 200) {
                return
            }
            lastUpdate = actualTime
            Toast.makeText(this, "Device was shuffled", Toast.LENGTH_SHORT)
                .show()
            if (color)
            {
                txt1.setBackgroundColor(Color.GREEN)
            } else {
                txt1.setBackgroundColor(Color.RED)
            }
            color = !color
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int)
    {

    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}