package com.example.giftshopproject.Activity

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.giftshopproject.Client.ApiClient
import com.example.giftshopproject.Interface.Apiinterface
import com.example.giftshopproject.Model.SignupModel
import com.example.giftshopproject.R
import com.example.giftshopproject.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences

    private var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val notConnected = intent.getBooleanExtra(
                ConnectivityManager
                .EXTRA_NO_CONNECTIVITY, false)
            if (notConnected) {
                disconnected()
            } else {
                connected()
            }
        }
    }

    private fun disconnected()
    {
        //View.INVISIBLE
        //View.VISIBLE
        //imageView.visibility = View.VISIBLE
    }

    private fun connected() {
       Toast.makeText(applicationContext,"Connected",Toast.LENGTH_LONG).show()
    }


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
        sharedPreferences = getSharedPreferences("TOPS",Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("TOPS",false) && !sharedPreferences.getString("phone","")!!
                .isEmpty())
        {

            startActivity(Intent(applicationContext,DashboardActivity::class.java))
            finish()

        }


        binding.btnLogIn.setOnClickListener {

            var phone = binding.edtPhone.text.toString()
            var pass = binding.edtPassword.text.toString()

         var call: Call<SignupModel> = apiinterface.loginuser(phone,pass)
         call.enqueue(object :Callback<SignupModel>
         {
             override fun onResponse(call: Call<SignupModel>, response: Response<SignupModel>)
             {
                Toast.makeText(applicationContext,"Logged in Succesfully",Toast.LENGTH_LONG).show()
                 var i = Intent(applicationContext,DashboardActivity::class.java)
                 var editor:SharedPreferences.Editor = sharedPreferences.edit()
                 editor.putBoolean("TOPS",true)
                 editor.putString("phone",phone)
                 editor.putString("pass",pass)
                 editor.commit()
                 startActivity(i)
             }

             override fun onFailure(call: Call<SignupModel>, t: Throwable)
             {
                 Toast.makeText(applicationContext,"Logged in Fail",Toast.LENGTH_LONG).show()
             }
         })

        }

        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,SignupActivity::class.java))

        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(broadcastReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}