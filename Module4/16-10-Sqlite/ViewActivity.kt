package tops.tech.sqlitedb

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog

class ViewActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>
    lateinit var dbHelper: DbHelper
    var arraylist:ArrayList<HashMap<String,String>> = ArrayList<HashMap<String,String>>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        listView = findViewById(R.id.list)
        list = ArrayList()
        dbHelper = DbHelper(applicationContext)

        list = dbHelper.viewdata()

        for(i in list)
        {
            var map = HashMap<String,String>()
            map.put("NAME",i.name)
            map.put("NUMBER",i.num)
            arraylist.add(map)
        }

        var from = arrayOf("NAME","NUMBER")
        var to = intArrayOf(R.id.txt1,R.id.txt2)

        var adapter = SimpleAdapter(applicationContext,arraylist,R.layout.design,from,to)
        listView.adapter=adapter

        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1:MenuItem = menu!!.add(0,1,0,"Update")
        var m2:MenuItem = menu!!.add(0,2,0,"Delete")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var pos = acm.position
        var m = list[pos]

        when(item.itemId)
        {
            1->
            {
                var i = Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("ID",m.id)
                i.putExtra("NAME",m.name)
                i.putExtra("NUMBER",m.num)
                startActivity(i)
            }
            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you Sure you want to delete?")
                alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->


                        dbHelper.deleetdata(m.id)
                        startActivity(Intent(applicationContext,ViewActivity::class.java))

                })
                alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()

                })
                alert.show()


            }
        }

        return super.onContextItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}