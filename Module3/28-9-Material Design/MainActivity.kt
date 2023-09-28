package tops.tech.toolbarex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    lateinit var f1:FloatingActionButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.tool)
        f1 = findViewById(R.id.f1)
        setSupportActionBar(toolbar)


        toolbar.setLogo(R.mipmap.ic_launcher)
        toolbar.setTitle("Xyz")
        toolbar.setSubtitle("lastseen")
        toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24)

        toolbar.setNavigationOnClickListener {

            Toast.makeText(applicationContext,"back button pressed",Toast.LENGTH_LONG).show()

        }

        f1.setOnClickListener {

            Snackbar.make(it,"Success",Snackbar.LENGTH_LONG).show()

        }

    }
}