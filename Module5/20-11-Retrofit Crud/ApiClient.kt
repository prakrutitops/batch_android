package tops.tech.retrofitcrudex

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {
        lateinit var retrofit:Retrofit
        var BASE_URL="https://compressible-approa.000webhostapp.com/Product_API/"

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