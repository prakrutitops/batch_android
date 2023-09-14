package tops.tech.customlistex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add(Model(R.drawable.a,"Person1","999999999"))
        list.add(Model(R.drawable.b,"Person2","888888888"))
        list.add(Model(R.drawable.c,"Person3","777777777"))
        list.add(Model(R.drawable.d,"Person4","666666666"))
        list.add(Model(R.drawable.a,"Person1","999999999"))
        list.add(Model(R.drawable.b,"Person2","888888888"))
        list.add(Model(R.drawable.c,"Person3","777777777"))
        list.add(Model(R.drawable.d,"Person4","666666666"))

        var myAdapter = MyAdapter(applicationContext,list)
        listView.adapter=myAdapter

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