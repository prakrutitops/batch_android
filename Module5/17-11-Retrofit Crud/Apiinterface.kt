package tops.tech.retrofitcrudex

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("productinsert.php")
    fun insertdata
       (
            @Field("product_name") p_name:String,
            @Field("product_price")  p_price:String,
            @Field("product_description")  p_des:String,
        ) : Call<Void>

    @GET("productview.php")
    fun getdata() :Call<List<Model>>
}