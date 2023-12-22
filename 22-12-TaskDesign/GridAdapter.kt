package com.example.swipeinternet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GridAdapter(private val dataList: List<String>) : RecyclerView.Adapter<MyView23>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView23 {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid, parent, false)
        return MyView23(view)
    }

    override fun onBindViewHolder(holder: MyView23, position: Int) {
        // Bind data to views
       // holder.txt1.se(dataList[position])

        holder.textView.setText(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }




}
class MyView23(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textView: TextView = Itemview.findViewById(R.id.txt1)


}
