package com.example.wakelockex

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.PowerManager
import android.os.PowerManager.WakeLock
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var lock:WakeLock
    lateinit var pm: PowerManager
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        pm = getSystemService(Context.POWER_SERVICE) as PowerManager



        btn1.setOnClickListener {

            if(pm!=null)
            {
                lock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "WakeLockExample:rushabh");
            }

            lock.acquire(10*60*1000L)
            lock.release()


        }

    }
}