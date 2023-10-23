package tops.tech.realmdb

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import io.realm.Realm
import io.realm.RealmResults

class ViewActivity : AppCompatActivity(), AdapterView.OnItemLongClickListener {
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>
    lateinit var realm: Realm

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        listView = findViewById(R.id.list)
        list = ArrayList()
        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        var results:RealmResults<Model> = realm.where(Model::class.java).findAll()

        for(i in results.indices)
        {
            list.add(results[i]!!)
        }

        var adapter = MyAdapter(applicationContext,list)
        listView.adapter=adapter

        listView.setOnItemLongClickListener(this)

    }

    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean
    {

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Select Operations?")
        alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

            var alert2 = AlertDialog.Builder(this)
            var layout = LayoutInflater.from(applicationContext)
            var view =layout.inflate(R.layout.edit,null)
            var edt1:EditText = view.findViewById(R.id.edtname)
            var edt2:EditText = view.findViewById(R.id.edtnum)
            var results:RealmResults<Model> = realm.where(Model::class.java).findAll()
            edt1.setText(results.get(p2)!!.name)
            edt2.setText(results.get(p2)!!.num)
            alert2.setView(view)
            alert2.setPositiveButton("Edit",{ dialogInterface: DialogInterface, i: Int ->

                    var e1 = edt1.text.toString()
                    var e2 = edt2.text.toString()

                //var results:RealmResults<Model> = realm.where(Model::class.java).findAll()
                realm.beginTransaction()
                list.get(p2).name = e1
                list.get(p2).num = e2
                realm.commitTransaction()
                startActivity(Intent(applicationContext,ViewActivity::class.java))

            })
            alert2.show()

        })
        alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

            realm.beginTransaction()

            var results:RealmResults<Model> = realm.where(Model::class.java).findAll()
            results.deleteFromRealm(p2)
            startActivity(Intent(applicationContext,ViewActivity::class.java))

            realm.commitTransaction()


        })

        alert.show()
        return false
    }

    override fun onBackPressed()
    {
        super.onBackPressed()
        finishAffinity()
    }


}