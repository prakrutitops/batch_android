package tops.tech.retrofitcrudex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewActivity : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var apiinterface: Apiinterface
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        recyclerView = findViewById(R.id.recycler)
        apiinterface = ApiClient.getretrofit().create(Apiinterface::class.java)
        list = ArrayList<Model>()

        var layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=layoutManager

       var call: Call<List<Model>> = apiinterface.getdata()
       call.enqueue(object:Callback<List<Model>>{

           override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {

                        list = response.body() as MutableList<Model>

                     var adapter = Myadapter(applicationContext, list)
                    recyclerView.adapter=adapter

           }

           override fun onFailure(call: Call<List<Model>>, t: Throwable) {

               Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
           }
       })
    }
}