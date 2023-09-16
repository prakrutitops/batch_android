package tops.tech.customlistex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity()
{
    lateinit var img:ImageView
    lateinit var txt1:TextView
    lateinit var txt2:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        img = findViewById(R.id.img1)
        txt1 = findViewById(R.id.txt1)
        txt2 = findViewById(R.id.txt2)

        var i = intent

        img.setImageResource(i.getIntExtra("image",0))
        txt1.setText(i.getStringExtra("name"))
        txt2.setText(i.getStringExtra("num"))

    }
}