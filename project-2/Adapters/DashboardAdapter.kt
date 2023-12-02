package com.example.giftshopproject.Adapters

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.giftshopproject.Interface.Apiinterface
import com.example.giftshopproject.Model.CategoryModel
import com.example.giftshopproject.R

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardAdapter(var context: Context,var list: List<CategoryModel>):RecyclerView.Adapter<MyView>()
{
    lateinit var apiinterface: Apiinterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design_dashboard,parent,false)
        return MyView(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView , position: Int)
    {

        holder.textView.setText(list.get(position).category_name)
        Picasso.get().load(list.get(position).category_img).into(holder.imageview)


    }
}
class MyView(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textView: TextView = Itemview.findViewById(R.id.text)
    var imageview: ImageView = Itemview.findViewById(R.id.img)

}