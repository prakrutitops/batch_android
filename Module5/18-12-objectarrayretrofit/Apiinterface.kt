package com.example.demo1


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @GET("heroes.php") // Replace with your actual endpoint
    fun getHeroes(): Call<HeroesResponse>
}