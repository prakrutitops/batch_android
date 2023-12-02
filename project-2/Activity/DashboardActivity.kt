package com.example.giftshopproject.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giftshopproject.Adapters.DashboardAdapter
import com.example.giftshopproject.Client.ApiClient
import com.example.giftshopproject.Interface.Apiinterface
import com.example.giftshopproject.Model.CategoryModel
import com.example.giftshopproject.R
import com.example.giftshopproject.databinding.ActivityDashboardBinding
import com.example.giftshopproject.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashboardBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var list:MutableList<CategoryModel>
    lateinit var apiinterface: Apiinterface
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.tool)
        sharedPreferences = getSharedPreferences("TOPS",Context.MODE_PRIVATE)

        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("phone","null"),Toast.LENGTH_LONG).show()


        list = ArrayList()

        var layoutManager:RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.recycler.layoutManager=layoutManager

        apiinterface=  ApiClient.getapiclient().create(Apiinterface::class.java)


        var call: Call<List<CategoryModel>> =  apiinterface.categoryviewdata()

        call.enqueue(object: Callback<List<CategoryModel>> {
            override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>) {

                Toast.makeText(applicationContext,"a",Toast.LENGTH_LONG).show()

                list = response.body() as MutableList<CategoryModel>

                var myAdapter = DashboardAdapter(applicationContext,list)
                binding.recycler.adapter=myAdapter
            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }


        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.dashboard_option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(applicationContext,LoginActivity::class.java))
                finish()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}