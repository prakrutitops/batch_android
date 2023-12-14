package com.example.giftshopproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.giftshopproject.Client.ApiClient
import com.example.giftshopproject.Interface.Apiinterface
import com.example.giftshopproject.R
import com.example.giftshopproject.databinding.ActivityCategoryBinding
import com.example.giftshopproject.databinding.ActivityDashboardBinding
import com.example.giftshopproject.databinding.ActivityFullScreenImageBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FullScreenImageActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullScreenImageBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenImageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        var i = intent
        var id = i.getIntExtra("id",101)
        var cid = i.getIntExtra("cid",102)
        var price= i.getIntExtra("price",0)
        var pname =  i.getStringExtra("name")
        var pdes =  i.getStringExtra("des")
        var pimage = i.getStringExtra("image")
        binding.txt1.setText(pname)
        binding.txt2.setText(price.toString())
        binding.txt3.setText(pdes)
        //binding.photoView.setImageResource(i.getStringExtra("image"))
        Picasso.get().load(i.getStringExtra("image")).into(binding.photoView)

        binding.btnwishlist.setOnClickListener {

            var call: Call<Void> =   apiinterface.addtowishlist(cid,pname.toString(),price,pimage.toString(),pdes.toString())

            call.enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    Toast.makeText(applicationContext,"Added to Wishlist", Toast.LENGTH_LONG).show()
                   startActivity(Intent(applicationContext,WishlistViewActivity::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Wishlist Fail", Toast.LENGTH_LONG).show()
                }
            })



        }
        binding.btncart.setOnClickListener {


        }


    }
}