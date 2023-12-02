package com.example.giftshopproject.Interface

import com.example.giftshopproject.Model.CategoryModel
import com.example.giftshopproject.Model.SignupModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("signup.php")
    fun signupuser(
        @Field("fname") fname:String,
        @Field("lname") lname:String,
        @Field("gender") gender:String,
        @Field("email") email:String,
        @Field("phone") phone:String,
        @Field("password") password:String,
            ): Call<Void>

    @FormUrlEncoded
    @POST("login.php")
    fun loginuser(
        @Field("phone") phone:String,
        @Field("password") password:String,
    ): Call<SignupModel>

    @GET("categoryview.php")
    fun categoryviewdata(): Call<List<CategoryModel>>




}