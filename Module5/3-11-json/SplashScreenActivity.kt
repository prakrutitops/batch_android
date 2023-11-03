package tops.tech.jsonparsingex8.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import tops.tech.jsonparsingex8.R

class SplashScreenActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(Runnable {

               startActivity(Intent(applicationContext,AdminLoginActivity::class.java))

        },3000)

    }
}