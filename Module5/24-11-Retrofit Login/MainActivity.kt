package tops.tech.retrofitregisterloginex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var apiinterface: Apiinterface

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        apiinterface = ApiClient.getretrofit().create(Apiinterface::class.java)

        btn1.setOnClickListener {

            var email = edt1.text.toString()
            var pass = edt2.text.toString()

            var call: Call<Model> = apiinterface.logindata(email,pass)
            call.enqueue(object:Callback<Model>
            {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {

                    Toast.makeText(applicationContext,"Login Done",Toast.LENGTH_LONG).show()

                }

                override fun onFailure(call: Call<Model>, t: Throwable)
                {

                    Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()

                }
            })
        }

    }
}