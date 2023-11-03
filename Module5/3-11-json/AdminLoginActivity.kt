package tops.tech.jsonparsingex8.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import tops.tech.jsonparsingex8.R
import tops.tech.jsonparsingex8.databinding.ActivityAdminLoginBinding
import tops.tech.jsonparsingex8.databinding.ActivityMainBinding

class AdminLoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdminLoginBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("SESSION",false) && !sharedPreferences.getString("mob","")!!.isEmpty())
        {
            startActivity(Intent(this,DashboardActivity::class.java))
            finish()
        }


        binding.btnLogIn.setOnClickListener {

            var mob = binding.edtPhone.text.toString()
            var pass = binding.edtPassword.text.toString()

            var stringrequest:StringRequest = object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/Shop_Crud_Api/adminlogin.php",{
                    response->
                        try
                        {
                                if(response.trim().equals("0"))
                                {
                                    Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
                                }
                                else
                                {
                                    Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                                    var editor:SharedPreferences.Editor = sharedPreferences.edit()
                                    editor.putBoolean("SESSION",true)
                                    editor.putString("mob",mob)
                                    editor.putString("pass",pass)
                                    editor.commit()
                                    startActivity(Intent(applicationContext,DashboardActivity::class.java))
                                }
                        }
                        catch(e:JSONException)
                        {
                            e.printStackTrace()
                        }

            },
                {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["mobile"]=mob
                    map["password"]=pass
                    return map
                }
            }

            var queue:RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)

        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}