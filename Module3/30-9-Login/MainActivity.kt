package tops.tech.xyz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import tops.tech.xyz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?)
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("USER_SESSION",Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("email","")!!.isEmpty())
        {
            startActivity(Intent(this,DashboardActivity::class.java))
            finish()
        }



        binding.btn1.setOnClickListener {

            var email = binding.edt1.text.toString()
            var pass = binding.edt2.text.toString()

            var editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean("USER_SESSION",true)
            editor.putString("email",email)
            editor.putString("pass",pass)
            editor.commit()

            startActivity(Intent(applicationContext,DashboardActivity::class.java))



        }
    }
}