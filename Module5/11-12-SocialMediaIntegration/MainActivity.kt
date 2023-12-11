package com.example.socialmediaintegrationex

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton


class MainActivity : AppCompatActivity()
{

    lateinit var login_button: LoginButton
    var callbackManager: CallbackManager? = null


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(application)
        setContentView(R.layout.activity_main)

        login_button= findViewById(R.id.login_button)

        callbackManager=CallbackManager.Factory.create()

        login_button.registerCallback(callbackManager!!,object : FacebookCallback<LoginResult> {
            override fun onCancel() {
                    Toast.makeText(applicationContext,"Login Cancelled",Toast.LENGTH_LONG).show()
            }

            override fun onError(error: FacebookException) {
                Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            }

            override fun onSuccess(result: LoginResult) {

                Toast.makeText(applicationContext,"Login Success \n "+result.accessToken,Toast.LENGTH_LONG).show()
            }
        })

    }
}