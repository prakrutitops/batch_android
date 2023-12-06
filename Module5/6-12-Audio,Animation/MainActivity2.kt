package com.example.myapplication


import android.R.attr
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.TransitionManager


class MainActivity2 : AppCompatActivity()
{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val transitionsContainer = findViewById(R.id.transitions_container) as LinearLayout
        val text = transitionsContainer.findViewById(R.id.text) as TextView
        val button = transitionsContainer.findViewById(R.id.button) as Button

        button.setOnClickListener {

            var visible = false

            TransitionManager.beginDelayedTransition(transitionsContainer)
            visible = !visible
            text.visibility = if (visible) View.VISIBLE else View.GONE

        }
    }
}