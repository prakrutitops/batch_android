package com.example.giftshopproject.Interface

import com.example.giftshopproject.Model.CartModel
import com.example.giftshopproject.Model.CategoryDetailModel
import com.example.giftshopproject.Model.CategoryModel
import com.example.giftshopproject.Model.SignupModel
import com.example.giftshopproject.Model.WishlistModel
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

    @FormUrlEncoded
    @POST("category_imagesview.php")
    fun categoryimageviewdata( @Field("data") data:Int): Call<List<CategoryDetailModel>>


    @FormUrlEncoded
    @POST("addtowishlist.php")
    fun addtowishlist(
        @Field("c_id") c_id:Int,
        @Field("pname") pname:String,
        @Field("pprice") pprice:Int,
        @Field("pimage") pimage:String,
        @Field("pdes") pdes:String,
    ): Call<Void>

    @FormUrlEncoded
    @POST("addtocart.php")
    fun addtocart(
        @Field("c_id") c_id:Int,
        @Field("pname") pname:String,
        @Field("pprice") pprice:Int,
        @Field("pimage") pimage:String,
        @Field("pdes") pdes:String,
    ): Call<Void>


    @GET("wishlistview.php")
    fun wishlistviewdata(): Call<List<WishlistModel>>

    @GET("cartview.php")
    fun cartviewdata(): Call<List<CartModel>>

    //deletefromwishlist.php
    @FormUrlEncoded
    @POST("deletefromwishlist.php")
    fun deletefromwishlist(@Field("id") id: Int): Call<WishlistModel?>?
}