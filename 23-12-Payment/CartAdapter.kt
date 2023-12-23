package com.example.giftshopproject.Adapters

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.giftshopproject.Activity.CategoryActivity
import com.example.giftshopproject.Activity.FullScreenImageActivity
import com.example.giftshopproject.Activity.PaymentActivity
import com.example.giftshopproject.Interface.Apiinterface
import com.example.giftshopproject.Model.CartModel
import com.example.giftshopproject.Model.CategoryDetailModel
import com.example.giftshopproject.Model.CategoryModel
import com.example.giftshopproject.Model.WishlistModel
import com.example.giftshopproject.R
import com.github.chrisbanes.photoview.PhotoView

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartAdapter(var context: Context,var list: List<CartModel>):RecyclerView.Adapter<MyView4>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView4
    {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design_cart,parent,false)
        return MyView4(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView4 , position: Int)
    {

        holder.textView.setText(list.get(position).pname)
        holder.textView2.setText(list.get(position).pprice.toString())
        holder.textView3.setText(list.get(position).pdes)
        var c_id = list.get(position).c_id
        Picasso.get().load(list.get(position).pimage).into(holder.imageview)
        Toast.makeText(context,""+c_id,Toast.LENGTH_LONG).show()
        holder.btnpayment.setOnClickListener {

            var i = Intent(context, PaymentActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            i.putExtra("id", list.get(position).id)
            i.putExtra("name", list.get(position).pname)
            i.putExtra("description", list.get(position).pdes)
            i.putExtra("price", list.get(position).pprice)
            i.putExtra("image", list.get(position).pimage)
            context.startActivity(i)

        }

    }
}
class MyView4(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textView: TextView = Itemview.findViewById(R.id.txt1)
    var textView2: TextView = Itemview.findViewById(R.id.txt2)
    var textView3: TextView = Itemview.findViewById(R.id.txt3)
    var imageview: PhotoView = Itemview.findViewById(R.id.photo_view)
    var btnpayment: Button = Itemview.findViewById(R.id.btnpayment)

}