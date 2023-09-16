package tops.tech.customlistex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()
        searchView = findViewById(R.id.search1)

        list.add(Model(R.drawable.a,"A1","999999999"))
        list.add(Model(R.drawable.b,"A2","888888888"))
        list.add(Model(R.drawable.c,"B1","777777777"))
        list.add(Model(R.drawable.d,"B2","666666666"))
        list.add(Model(R.drawable.a,"C1","999999999"))
        list.add(Model(R.drawable.b,"C2","888888888"))
        list.add(Model(R.drawable.c,"D1","777777777"))
        list.add(Model(R.drawable.d,"D2","666666666"))

        var myAdapter = MyAdapter(applicationContext,list)
        listView.adapter=myAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean
            {
                myAdapter.filter(newText.orEmpty())
                return true
            }
        })

        listView.setOnItemClickListener { parent, view, position, id ->


           // Toast.makeText(applicationContext,""+position,Toast.LENGTH_LONG).show()

            var i = Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("pos",position)
            i.putExtra("name",list.get(position).name)
            i.putExtra("num",list.get(position).number)
            i.putExtra("image",list.get(position).image)
            startActivity(i)




        }

    }


}