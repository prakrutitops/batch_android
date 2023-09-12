package tops.tech.data123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import tops.tech.data123.databinding.ActivityListBinding
import tops.tech.data123.databinding.ActivityMainBinding

class ListActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityListBinding
    lateinit var list:MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        list.add("Android")
        list.add("Java")
        list.add("Php")
        list.add("Ios")


        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        binding.list.adapter=adapter

        binding.search.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                /*if(list.contains(query))
                {
                    adapter.filter.filter(query)
                }*/
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean
            {
                adapter.filter.filter(newText)
               return false
            }
        })


    }
}