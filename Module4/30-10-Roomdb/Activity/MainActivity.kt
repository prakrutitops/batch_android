package tops.tech.roomdbex.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import tops.tech.roomdbex.Adapter.MyAdapter
import tops.tech.roomdbex.Database.MyDatabase
import tops.tech.roomdbex.Entity.User
import tops.tech.roomdbex.R
import tops.tech.roomdbex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list:MutableList<User>
    lateinit var db: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?)
    {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        db = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "myDatabase").allowMainThreadQueries().build()
        list = ArrayList()

        var recycler: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager = recycler

        list = db.daoClass().viewdata()

        var adapter = MyAdapter(applicationContext,list)
        binding.recycler.adapter=adapter

        binding.f1.setOnClickListener {

            startActivity(Intent(applicationContext,AdduserActivity::class.java))

        }

    }


}