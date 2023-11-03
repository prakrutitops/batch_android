package tops.tech.jsonparsingex8.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tops.tech.jsonparsingex8.R

class DashboardActivity : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    lateinit var recyclerView: RecyclerView
    lateinit var list:MutableList<DashboardModel>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE)

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList()

        //listview format
        /* var manager : RecyclerView.LayoutManager = LinearLayoutManager(this)
         recyclerView.layoutManager=manager*/

        //gridview format
        var manager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager=manager

        list.add(DashboardModel(R.drawable.adduser,"Add User"))
        list.add(DashboardModel(R.drawable.addproduct,"Add Product"))
        list.add(DashboardModel(R.drawable.viewproduct,"View Products"))
        list.add(DashboardModel(R.drawable.aboutus,"About us"))

        var myAdapter = MyAdapter(applicationContext,list)
        recyclerView.adapter=myAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                finish()
                startActivity(Intent(applicationContext,AdminLoginActivity::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}