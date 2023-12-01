package com.example.profiletask

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import org.json.JSONException
import org.json.JSONObject

class AnimalActivity : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    lateinit var img1:ImageView
    lateinit var txtnm:TextView
    lateinit var txtemail:TextView
    lateinit var txtid:TextView
    lateinit var txtpass:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
        img1=findViewById(R.id.img)
        txtnm=findViewById(R.id.txtnm)
        txtemail=findViewById(R.id.txtemail)
        txtpass=findViewById(R.id.txtpass)
        txtid=findViewById(R.id.txtid)

      var email =  sharedPreferences.getString("email","")
      var pass =  sharedPreferences.getString("pass","")

        var stringrequest: StringRequest = object: StringRequest(
            Request.Method.POST,"https://topsapi.000webhostapp.com/task/profile.php",{
                response->
            try
            {
                    var jsonObject = JSONObject(response)
                    var jsonArray = jsonObject.getJSONArray("result")

                    for(i in 0..jsonArray.length())
                    {
                        var jsonObject2 = jsonArray.getJSONObject(i)

                        var id = jsonObject2.getInt("id")
                        var name = jsonObject2.getString("name")
                        var email = jsonObject2.getString("email")
                        var pass = jsonObject2.getString("password")
                        var img = jsonObject2.getString("img")

                        var m= Mode()
                        m.id=id
                        m.name=name
                        m.email=email
                        m.password=pass
                        m.img=img


                        txtnm.setText(name)
                        txtid.setText(id.toString())
                        txtemail.setText(email)
                        txtpass.setText(pass)

                        Picasso.get().load(img).into(img1)
                        Toast.makeText(applicationContext,"Response: "+m.name+" "+m.email+" "+m.password+" "+m.img,Toast.LENGTH_LONG).show()

                    }


            }
            catch(e: JSONException)
            {
                e.printStackTrace()
            }

        },
            {
                Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
            })
        {
            override fun getParams(): MutableMap<String, String>?
            {
                var map = HashMap<String,String>()
                map["email"]=email.toString()
                map["password"]=pass.toString()
                return map
            }
        }

        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringrequest)



    }
}