package tops.tech.sqlitedb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var dbHelper: DbHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtnum)
        btn1 = findViewById(R.id.btninsert)
        btn2 = findViewById(R.id.btnview)
        dbHelper = DbHelper(applicationContext)

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var number = edt2.text.toString()

            //Model class - set & get

            var m = Model()
            m.name=name
            m.num=number

           var data =  dbHelper.insertdata(m)

            Toast.makeText(applicationContext,"Record Inserted "+data,Toast.LENGTH_LONG).show()
        }
        btn2.setOnClickListener {

            startActivity(Intent(applicationContext,ViewActivity::class.java))

        }
    }
}