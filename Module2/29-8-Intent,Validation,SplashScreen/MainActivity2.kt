package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit var e1:EditText
    lateinit var e2:EditText
    lateinit var b1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        e1= findViewById(R.id.edt1)
        e2= findViewById(R.id.edt2)
        b1= findViewById(R.id.btn1)

        b1.setOnClickListener {

            var name = e1.text.toString()
            var pass = e2.text.toString()

            if(name.length==0 && pass.length==0)
            {
                e1.setError("Please Enter Name")
                e2.setError("Please Enter Password")
            }
            else if(name.length==0)
            {
                e1.setError("Please Enter Name")

            }
            else if(pass.length==0)
            {
                e2.setError("Please Enter Password")

            }
            else
            {


                if(name.equals("tops") && pass.equals("1234"))
                {
                    var i1= Intent(applicationContext,MainActivity::class.java)
                    startActivity(i1)
                    Toast.makeText(applicationContext, "Login Succesfully", Toast.LENGTH_LONG).show()

                }
                else
                {
                    Toast.makeText(applicationContext, "Wrong Credentials", Toast.LENGTH_LONG).show()

                }


            }







        }
    }
}