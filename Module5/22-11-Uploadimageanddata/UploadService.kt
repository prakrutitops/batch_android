package tops.tech.uploadimageanddata

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadService
{
    @Multipart
    @POST("uploaddata.php")
    suspend fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("emp_name") emp_name: RequestBody?,
        @Part("emp_mobile") emp_mobile: RequestBody?,
        @Part("emp_email") emp_email: RequestBody?,
        @Part("emp_pass") emp_pass: RequestBody?,


        ): ResponseBody
}