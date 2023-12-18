package com.example.demo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var sliderlayout: SliderLayout
    var map = HashMap<String, Int>()
    lateinit var apiinterface: Apiinterface
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sliderlayout = findViewById(R.id.slider)

        recyclerView = findViewById(R.id.recycler)
        apiinterface = ApiClient.getretrofit().create(Apiinterface::class.java)
        list = ArrayList<Model>()

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        map.put("A", R.drawable.c2)
        map.put("B", R.drawable.f1)
        map.put("C", R.drawable.c2)
        map.put("D", R.drawable.f1)

        for (i in map.keys) {
            var textslider = TextSliderView(this)
            textslider.description(i)
            textslider.image(map.get(i)!!)
            sliderlayout.addSlider(textslider)
        }
        sliderlayout.setPresetTransformer(SliderLayout.Transformer.ZoomIn)


        var call: Call<List<Model>> = apiinterface.getdata()
        call.enqueue(object : Callback<List<Model>> {

            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {

                list = response.body() as MutableList<Model>

                var adapter = Myadapter(applicationContext, list)
                recyclerView.adapter = adapter

            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {

                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
            }
        })
    }
}