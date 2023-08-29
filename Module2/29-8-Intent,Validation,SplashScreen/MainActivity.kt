package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    //Declare
    lateinit var img1:ImageView
    lateinit var txt1:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize
        //Connect with XML

        img1 = findViewById(R.id.i1)
        txt1 = findViewById(R.id.t1)


        txt1.setOnClickListener {

            //Toast.makeText(applicationContext,"Welcome to tops",Toast.LENGTH_LONG).show()
            //explicit
            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
       }

        img1.setOnClickListener {

            //Toast.makeText(applicationContext, "Welcome to Rajkot", Toast.LENGTH_SHORT).show()

            //implicit
            var url="https://www.tops-int.com"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)

        }


    }
}