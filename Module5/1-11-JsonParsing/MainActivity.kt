package tops.tech.jsonparsingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import tops.tech.jsonparsingex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        list = ArrayList()

       var stringRequest = StringRequest(Request.Method.GET,"https://compressible-approa.000webhostapp.com/API/view.php",{response->
           try
           {
               var jsonArray = JSONArray(response)
               for(i in 0 until jsonArray.length())
               {
                   var jsonObject = jsonArray.getJSONObject(i)

                   var cricketer_name = jsonObject.getString("cricketer_name")
                   var cricketer_hscore = jsonObject.getString("cricketer_hscore")
                   var cricketer_photo = jsonObject.getString("cricketer_photo")
                   var m = Model()
                   m.cricketer_name=cricketer_name
                   m.cricketer_hscore = cricketer_hscore
                   m.cricketer_photo=cricketer_photo
                   list.add(m)

               }
               var adapter = MyAdapter(applicationContext,list)
               binding.list.adapter=adapter

           }
           catch (e:Exception)
           {
               e.printStackTrace()
           }
       })
       {
            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
       }

        var queue:RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)


    }
}