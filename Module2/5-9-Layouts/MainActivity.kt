package tops.tech.layoutsex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    lateinit var linearLayout: LinearLayout
    lateinit var txt1:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        linearLayout = LinearLayout(this)
        txt1 = TextView(this)
        txt1.setText("Tops")

        var width=250
        var height=250

        linearLayout.addView(txt1,width, height)
        setContentView(linearLayout)
    }
}