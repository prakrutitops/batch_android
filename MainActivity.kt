package com.example.wifionoff

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var imageView: ImageView
    private lateinit var onBtn: Button
    private lateinit var wifiManager: WifiManager

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tv)
        imageView = findViewById(R.id.imgBtn)
        onBtn = findViewById(R.id.onBtn)
        wifiManager = applicationContext
            .getSystemService(Context.WIFI_SERVICE) as WifiManager

        onBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val panelIntent = Intent(Settings.Panel.ACTION_WIFI)
                startActivity(panelIntent)
            } else {
                if (!wifiManager.isWifiEnabled) {
                    wifiManager.isWifiEnabled = true
                    onBtn.text = "Turn WiFi ON"
                } else {
                    wifiManager.isWifiEnabled = false
                    onBtn.text = "Turn WiFi OFF"
                }
            }
        }

        if (wifiManager.isWifiEnabled) {
            imageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_wifi_24,
                    applicationContext.theme
                )
            )
            textView.text = "WiFi is On"
            onBtn.text = "Turn WiFi Off"
        } else {
            imageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_wifi_off_24,
                    applicationContext.theme
                )
            )
            textView.text = "WiFi is Off"
            onBtn.text = "Turn WiFi On"
        }
    }

    override fun onResume() {
        super.onResume()
        if (wifiManager.isWifiEnabled) {
            imageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_wifi_24,
                    applicationContext.theme
                )
            )
            textView.text = "WiFi is On"
            onBtn.text = "Turn WiFi Off"
        } else {
            imageView.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.baseline_wifi_off_24,
                    applicationContext.theme
                )
            )
            textView.text = "WiFi is Off"
            onBtn.text = "Turn WiFi On"
        }
    }
}