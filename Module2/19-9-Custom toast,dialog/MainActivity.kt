package tops.tech.customtoastdialog

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    //lateinit var linearlayout:LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        //linearlayout = findViewById(R.id.line)

        btn1.setOnClickListener {
            //layoutinflater - layout
            //menuinflate - menu
            var toast = Toast(applicationContext)
            var layout = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.design_toast,null)
            toast.view=view
            toast.setGravity(Gravity.CENTER,0,0)
            toast.duration=Toast.LENGTH_LONG
            toast.show()

        }
        btn2.setOnClickListener {

            var alertdialog = AlertDialog.Builder(this)
            var layout = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.design_dialog,null)

            var btn1:Button = view.findViewById(R.id.btn1)
            var btn2:Button = view.findViewById(R.id.btn2)

            btn1.setOnClickListener {

                Toast.makeText(applicationContext,"abcd",Toast.LENGTH_LONG).show()

            }
            btn2.setOnClickListener {

                Toast.makeText(applicationContext,"pqrs",Toast.LENGTH_LONG).show()
            }

            alertdialog.setView(view)
            alertdialog.show()
        }


        //linearlayout.visibility = View.GON


    }
}