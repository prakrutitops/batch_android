package tops.tech.recyclerviewex

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var list:MutableList<Model>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList()

        //listview format
       /* var manager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=manager*/

        //gridview format
        var manager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager=manager

        list.add(Model(R.drawable.a,"person 1"))
        list.add(Model(R.drawable.b,"person 2"))
        list.add(Model(R.drawable.c,"person 3"))
        list.add(Model(R.drawable.d,"person 4"))

        var myAdapter = MyAdapter(applicationContext,list)
        recyclerView.adapter=myAdapter



    }
}