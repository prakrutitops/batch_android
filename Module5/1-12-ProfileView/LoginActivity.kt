package com.example.profiletask

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class LoginActivity : AppCompatActivity() {

   lateinit var btnlogin: Button
    lateinit var edtemail: EditText
    lateinit var edtpass: EditText
    var m: Mode = Mode()
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnlogin = findViewById<Button>(R.id.btn_login)

        edtemail = findViewById<EditText>(R.id.et_email)
        edtpass = findViewById<EditText>(R.id.et_pass)

        sharedPreferences = getSharedPreferences("USER_SESSION",Context.MODE_PRIVATE)
        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email","")!!.isEmpty())
        {
            startActivity(Intent(this,AnimalActivity::class.java))
            finish()
        }






        btnlogin!!.setOnClickListener {

            var mob = edtemail.text.toString()
            var pass = edtpass.text.toString()


            var stringrequest:StringRequest = object:StringRequest(Request.Method.POST,"https://topsapi.000webhostapp.com/task/login.php",{
                    response->
                try
                {
                    if(response.trim().equals("0"))
                    {
                        Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        var editor:SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putBoolean("USER_SESSION",true)
                        editor.putString("email",mob)
                        editor.putString("pass",pass)
                        editor.commit()
                        startActivity(Intent(applicationContext,AnimalActivity::class.java))
                    }
                }
                catch(e:JSONException)
                {
                    e.printStackTrace()
                }

            },
                {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["email"]=mob
                    map["password"]=pass
                    return map
                }
            }

            var queue:RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)

        }



    }
    }
