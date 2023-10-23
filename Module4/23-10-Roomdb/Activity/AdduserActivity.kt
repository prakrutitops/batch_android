package tops.tech.roomdbex.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import tops.tech.roomdbex.DatabaseClass
import tops.tech.roomdbex.Model.User
import tops.tech.roomdbex.databinding.ActivityAdduserBinding


class AdduserActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdduserBinding
    lateinit var db: DatabaseClass
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()

        binding.btninsert.setOnClickListener {

            var name = binding.edt1.text.toString()
            var num = binding.edt2.text.toString()

            var u = User()
            u.user_name=name
            u.user_number=num

            db.daoClass().addUser(u)
            Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()
        }



    }
}