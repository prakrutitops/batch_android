package com.example.adminpanel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.RecyclerView


class Myadapter(var context: Context,var list: MutableList<Model>):RecyclerView.Adapter<MyView>(),
    AdapterView.OnItemSelectedListener {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design,parent,false)
        return MyView(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView , position: Int)
    {


        Log.d("xyzxyz",list.get(position).product_name)
        var categoryarray = arrayOf(list.get(position).product_name)
        holder.spinner.setAdapter(ArrayAdapter<Any?>(
                context,
                android.R.layout.simple_dropdown_item_1line,
                categoryarray
            )



        )
        holder.spinner.setOnItemSelectedListener(this)
        //holder.spinner.setTag()
    //        .setText(list.get(position).product_name)






    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}
class MyView(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var spinner: Spinner = Itemview.findViewById(R.id.spin)




}