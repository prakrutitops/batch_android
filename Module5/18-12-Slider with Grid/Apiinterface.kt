package com.example.demo1


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{


    @GET("C_View.php")
    fun getdata() :Call<List<Model>>



}