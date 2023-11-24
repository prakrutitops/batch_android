package tops.tech.retrofitregisterloginex

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("login.php")
    fun logindata
       (
            @Field("email") email:String,
            @Field("password")  password:String,
        ) : Call<Model>
}