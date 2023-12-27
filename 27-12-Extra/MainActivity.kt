package com.example.designtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity()
{
    lateinit var webview:WebView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webview = findViewById(R.id.web)
        webview.loadUrl("https://www.javatpoint.com/")


    }
}