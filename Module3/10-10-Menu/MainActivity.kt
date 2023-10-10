package tops.tech.menuex

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<String>
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listView = findViewById(R.id.list)
        list= ArrayList()
        btn1 = findViewById(R.id.btn1)

        list.add("Android")
        list.add("Java")
        list.add("Php")
        list.add("Ios")

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter = adapter
        registerForContextMenu(listView)



        btn1.setOnClickListener {

            var popupmenu = PopupMenu(applicationContext,btn1)
            popupmenu.menuInflater.inflate(R.menu.popup,popupmenu.menu)
            popupmenu.setOnMenuItemClickListener(object :PopupMenu.OnMenuItemClickListener{
                override fun onMenuItemClick(item: MenuItem?): Boolean
                {
                    when(item!!.itemId)
                    {
                        R.id.popup->
                        {
                            Toast.makeText(applicationContext,"Popup Called",Toast.LENGTH_LONG).show()
                        }
                    }

                    return true
                }


            })
            popupmenu.show()



        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId)
        {
            R.id.i1->
            {
                var num ="99999999"
                var i = Intent(Intent.ACTION_CALL)
                i.setData(Uri.parse("tel:"+num))
                startActivity(i)

            }
            R.id.i2->
            {
                var desnum="9099972756"
                var sms1 ="testing message"
                var i = Intent(applicationContext,MainActivity::class.java)
                var pi = PendingIntent.getActivity(applicationContext,0,i, PendingIntent.FLAG_IMMUTABLE)
                var sms=SmsManager.getDefault()
                sms.sendTextMessage(desnum,null,sms1,pi,null)
                startActivity(i)

            }
        }


        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var pos = acm.position
        when(item.itemId)
        {
            R.id.pos->
            {
                Toast.makeText(applicationContext,"Poisition cALLED "+pos,Toast.LENGTH_LONG).show()
            }
        }

        return super.onContextItemSelected(item)
    }


}