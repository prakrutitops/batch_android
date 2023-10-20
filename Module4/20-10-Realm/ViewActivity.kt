package tops.tech.realmdb

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import io.realm.Realm
import io.realm.RealmResults

class ViewActivity : AppCompatActivity()
{
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


    }
}