package com.example.demo1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = ApiClient.instance

        val call = service.getHeroes()

        call.enqueue(object : Callback<HeroesResponse> {
            override fun onResponse(call: Call<HeroesResponse>, response: Response<HeroesResponse>) {
                if (response.isSuccessful) {
                    val heroesResponse = response.body()
                    // Handle the response here
                    val heroesList = heroesResponse?.heroes
                    // Process the list of heroes



                } else {
                    // Handle unsuccessful response
                }
            }

            override fun onFailure(call: Call<HeroesResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
