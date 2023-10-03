package tops.tech.prefrencescreenex

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var txt1:TextView
    lateinit var sharedPreferences: SharedPreferences
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        txt1 = findViewById(R.id.txt1)

        btn1.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }
        btn2.setOnClickListener {

           sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext)

            txt1.append("\n Your Name: "+sharedPreferences.getString("edt1","error"))
            txt1.append("\n Your Email: "+sharedPreferences.getString("edt2","error"))
            txt1.append("\n Your status: "+sharedPreferences.getBoolean("check1",false).toString())
            txt1.append("\n Your Language: "+sharedPreferences.getString("list1","error"))


        }

    }
}