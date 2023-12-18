package com.example.demo1


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private const val BASE_URL = "https://www.simplifiedcoding.net/demos/view-flipper/" // Replace with your actual base URL

    val instance: Apiinterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Apiinterface::class.java)
    }
}
