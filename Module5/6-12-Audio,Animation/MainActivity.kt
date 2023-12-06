package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{
    lateinit var imageview:ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageview = findViewById(R.id.img)
        animatation()

    }

    private fun animatation()
    {
        var animation:Animation = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate)
        imageview.startAnimation(animation)
    }
}