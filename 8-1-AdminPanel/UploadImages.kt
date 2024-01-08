package com.example.adminpanel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UploadImages : AppCompatActivity()
{
    lateinit var apiinterface: UploadService
    lateinit var list:MutableList<Model>
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_images)

        recyclerView = findViewById(R.id.recycle)

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager

        apiinterface = ApiClient.getapiclient().create(UploadService::class.java)
        list = ArrayList()

        var call: Call<List<Model>> = apiinterface.getdata()
        call.enqueue(object: Callback<List<Model>>
        {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>)
            {
                list = response.body() as MutableList<Model>

                var adapter = Myadapter(applicationContext,list)
                recyclerView.adapter=adapter

            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable)
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })

    }
}