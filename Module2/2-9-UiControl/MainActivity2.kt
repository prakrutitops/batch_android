package tops.tech.cafeex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity()
{
    lateinit var txt1:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var i = intent


        txt1 = findViewById(R.id.txt1)

        txt1.setText(i.getStringExtra("bill"))


    }
}