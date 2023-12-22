package com.example.swipeinternet

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TestActivity2 : AppCompatActivity()
{
    lateinit var  scrollableLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        scrollableLayout = findViewById(R.id.scrollableLayout)

        val data: List<String> = arrayListOf("1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5","1","2","3","4","5",)

        val chunkedData = data.chunked(10) // Split the list into chunks of 10

        chunkedData.forEach { chunkList ->
            val recyclerView = RecyclerView(this)
            recyclerView.layoutManager = GridLayoutManager(this, 5) // 5 columns in grid
            recyclerView.adapter = GridAdapter(chunkList)


            scrollableLayout.addView(recyclerView)
        }
    }
}
