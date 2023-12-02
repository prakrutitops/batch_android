package com.example.giftshopproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.giftshopproject.R

class SplashScreenActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(Runnable {

              startActivity(Intent(applicationContext,LoginActivity::class.java))

        },4000)

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}