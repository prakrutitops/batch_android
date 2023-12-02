package com.example.giftshopproject.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.example.giftshopproject.Client.ApiClient
import com.example.giftshopproject.Interface.Apiinterface
import com.example.giftshopproject.R
import com.example.giftshopproject.databinding.ActivityLoginBinding
import com.example.giftshopproject.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var binding: ActivitySignupBinding
    lateinit var apiinterface:Apiinterface

    var gender=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
        binding.textView3.setOnClickListener {
            startActivity(Intent(applicationContext,LoginActivity::class.java))
        }

        binding.rbMale.setOnCheckedChangeListener(this)
        binding.rbFemale.setOnCheckedChangeListener(this)

        binding.btnsignup.setOnClickListener {

            var fname = binding.edtFirstName.text.toString()
            var lname = binding.edtLastName.text.toString()
            var email = binding.edtEmail.text.toString()
            var phone = binding.edtPhone.text.toString()
            var password = binding.edtPassword.text.toString()


            var call: Call<Void> =  apiinterface.signupuser(fname,lname, gender, email, phone, password)

            call.enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    Toast.makeText(applicationContext,"Signup Succesful",Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,LoginActivity::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
                }
            })




        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean)
    {
        if(binding.rbMale.isChecked)
        {
            gender="Male"
        }
        if(binding.rbFemale.isChecked)
        {
            gender="Female"
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}