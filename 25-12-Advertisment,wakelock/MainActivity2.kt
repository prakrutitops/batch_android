package com.example.wakelockex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView


class MainActivity2 : AppCompatActivity()
{
    lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mAdView = findViewById(R.id.adView)

        val adRequest: AdRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


    }
}