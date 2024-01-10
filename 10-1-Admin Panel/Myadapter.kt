package com.example.adminpanel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class Myadapter(var context: Context,var list: MutableList<Model>):RecyclerView.Adapter<MyView>()
{



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design,parent,false)
        return MyView(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView , position: Int)
    {
       var data = list.get(position).id
       holder.textview.setText(list.get(position).product_name)
       holder.itemView.setOnClickListener {

           Toast.makeText(context,""+data,Toast.LENGTH_LONG).show()



       }
    }



}
class MyView(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textview: TextView = Itemview.findViewById(R.id.txt1)
}