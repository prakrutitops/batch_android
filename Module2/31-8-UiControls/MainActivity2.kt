package com.example.app2

import android.Manifest.permission.CALL_PHONE
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity2 : AppCompatActivity(), TextToSpeech.OnInitListener {

    lateinit var edt1:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var tts:TextToSpeech
    lateinit var img:ImageView
    lateinit var btn3:Button
    lateinit var btn4:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        edt1 = findViewById(R.id.edt1)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        tts = TextToSpeech(applicationContext,this)
        img = findViewById(R.id.img1)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)

        //runtime permission
        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE),1)
        }

        btn1.setOnClickListener {

            var data = edt1.text.toString()
            tts.speak(data,QUEUE_ADD,null)

        }

        btn2.setOnClickListener {

            var i = Intent(ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,1)//request
        }

        btn3.setOnClickListener {

            var num="9275003605"
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)
        }

        btn4.setOnClickListener {

            var data = edt1.text.toString()
            var i = Intent(applicationContext,MainActivity3::class.java)
            i.putExtra("a1",data)
            startActivity(i)


        }


    }
    //result
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if(requestCode==1 && resultCode == RESULT_OK)
        {
            var bm:Bitmap = data!!.extras!!.get("data") as Bitmap
            img.setImageBitmap(bm)

        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onBackPressed()
    {
        //finishAffinity()

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Are you sure you want to exit?")
        alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

           finishAffinity()
        })
        alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()
        })
        alert.show()


    }

    override fun onInit(status: Int)
    {
        tts.setLanguage(Locale.US)
        tts.setPitch(0.5F)
        tts.setSpeechRate(0.8F)
    }
}

