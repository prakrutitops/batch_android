package tops.tech.sqlitedb

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class UpdateActivity : AppCompatActivity()
{
    lateinit var dbHelper: DbHelper
    lateinit var edt1: EditText
    lateinit var edt2: EditText
    lateinit var btn1: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtnum)
        btn1 = findViewById(R.id.btnupdate)

        var i = intent
       var id = i.getIntExtra("ID",101)
       var name =  i.getStringExtra("NAME")
       var num =  i.getStringExtra("NUMBER")

        edt1.setText(name)
        edt2.setText(num)
        dbHelper = DbHelper(applicationContext)
        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var num = edt2.text.toString()

            var m = Model()
            m.id=id
            m.name=name
            m.num=num

            dbHelper.updatedata(m)
            startActivity(Intent(applicationContext,ViewActivity::class.java))

        }



    }
}