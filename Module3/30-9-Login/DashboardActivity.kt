package tops.tech.xyz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import tops.tech.xyz.databinding.ActivityDashboardBinding
import tops.tech.xyz.databinding.ActivityMainBinding

class DashboardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashboardBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)
        binding.txt1.setText("Welcome "+sharedPreferences.getString("email",""))
        binding.btn1.setOnClickListener {

            sharedPreferences.edit().clear().commit()
            finish()
            startActivity(Intent(applicationContext,MainActivity::class.java))

        }
        //Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("email",""),Toast.LENGTH_LONG).show()
    }
}