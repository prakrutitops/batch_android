package com.example.adminpanel

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadService
{
    @Multipart
    @POST("addcategory.php")
    suspend fun uploadImage(
        @Part product_image:MultipartBody.Part,
        @Part("product_name") product_name: RequestBody?,
        ):ResponseBody

    @GET("categoryview.php")
    fun getdata() : Call<List<Model>>

}