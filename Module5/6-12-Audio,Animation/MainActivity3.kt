package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity3 : AppCompatActivity(), MediaPlayer.OnPreparedListener {
    var url = "https://topsapi.000webhostapp.com/serverimage/ram_siya_ram.mp3"
    var mediaPlayer: MediaPlayer = MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        mediaPlayer.setDataSource(url)
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener(this)


    }

    override fun onPrepared(mp: MediaPlayer?)
    {
        mediaPlayer.start()
    }
}