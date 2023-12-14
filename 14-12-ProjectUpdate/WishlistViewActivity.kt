package com.example.giftshopproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.giftshopproject.Adapters.CategoryAdapter
import com.example.giftshopproject.Adapters.WishlistAdapter
import com.example.giftshopproject.Client.ApiClient
import com.example.giftshopproject.Interface.Apiinterface
import com.example.giftshopproject.Model.CategoryDetailModel
import com.example.giftshopproject.Model.CategoryModel
import com.example.giftshopproject.Model.WishlistModel
import com.example.giftshopproject.R
import com.example.giftshopproject.databinding.ActivityCategoryBinding
import com.example.giftshopproject.databinding.ActivityDashboardBinding
import com.example.giftshopproject.databinding.ActivityWishlistViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WishlistViewActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityWishlistViewBinding
    lateinit var apiinterface: Apiinterface
    lateinit var call: Call<List<WishlistModel>>
    lateinit var list:MutableList<WishlistModel>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityWishlistViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiinterface=  ApiClient.getapiclient().create(Apiinterface::class.java)
        list = ArrayList()



        var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.recycler.layoutManager=layoutManager



        var call:Call<List<WishlistModel>> =  apiinterface.wishlistviewdata()

        call.enqueue(object:Callback<List<WishlistModel>>
        {
            override fun onResponse(call: Call<List<WishlistModel>>, response: Response<List<WishlistModel>>) {


                list = response.body() as MutableList<WishlistModel>

                var cadapter = WishlistAdapter(applicationContext,list)
                binding.recycler.adapter=cadapter
            }

            override fun onFailure(call: Call<List<WishlistModel>>, t: Throwable) {

            }
        })



    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(applicationContext,DashboardActivity::class.java))
    }
}