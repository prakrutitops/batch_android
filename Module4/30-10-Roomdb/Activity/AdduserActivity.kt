package tops.tech.roomdbex.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.roomdb.globalVariables.GlobalVariables
import tops.tech.roomdbex.Database.MyDatabase
import tops.tech.roomdbex.Entity.User
import tops.tech.roomdbex.R
import tops.tech.roomdbex.databinding.ActivityAdduserBinding
import tops.tech.roomdbex.databinding.ActivityMainBinding

class AdduserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdduserBinding
    lateinit var db: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "myDatabase").allowMainThreadQueries().build()

        if(GlobalVariables.updateFlag.equals("update"))
        {
            binding.edt1.setText(GlobalVariables.name)
            binding.edt2.setText(GlobalVariables.number)
        }


        binding.btn1.setOnClickListener {

            //update
            if(GlobalVariables.updateFlag.equals("update"))
            {
                var name = binding.edt1.text.toString()
                var num = binding.edt2.text.toString()

                var u = User()
                u.id=GlobalVariables.id
                u.name=name
                u.number=num

                db.daoClass().updatedata(u)

                Toast.makeText(applicationContext,"Updated",Toast.LENGTH_LONG).show()
                startActivity(Intent(applicationContext,MainActivity::class.java))
            }
            //insert
            else
            {
                var name = binding.edt1.text.toString()
                var num = binding.edt2.text.toString()

                var u = User()
                u.name=name
                u.number=num

                db.daoClass().addata(u)

                Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()
                startActivity(Intent(applicationContext,MainActivity::class.java))
            }



        }

    }
}