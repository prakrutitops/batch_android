package com.example.demo1


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {
        lateinit var retrofit:Retrofit
        var BASE_URL="https://unaffecting-firearm.000webhostapp.com/Essayrental-Project/"

        fun getretrofit(): Retrofit
        {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }

    }

}