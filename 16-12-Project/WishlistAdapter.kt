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
import com.example.giftshopproject.Activity.CartViewActivity
import com.example.giftshopproject.Activity.CategoryActivity
import com.example.giftshopproject.Activity.FullScreenImageActivity
import com.example.giftshopproject.Client.ApiClient
import com.example.giftshopproject.Interface.Apiinterface
import com.example.giftshopproject.Model.CategoryDetailModel
import com.example.giftshopproject.Model.CategoryModel
import com.example.giftshopproject.Model.WishlistModel
import com.example.giftshopproject.R
import com.github.chrisbanes.photoview.PhotoView

import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WishlistAdapter(var context: Context,var list: List<WishlistModel>):RecyclerView.Adapter<MyView3>()
{
        lateinit var apiinterface:Apiinterface

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView3
    {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design_wishlist,parent,false)
        return MyView3(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView3 , position: Int)
    {

        holder.textView.setText(list.get(position).pname)
        holder.textView2.setText(list.get(position).pprice.toString())
        holder.textView3.setText(list.get(position).pdes)
        var c_id = list.get(position).c_id
        Picasso.get().load(list.get(position).pimage).into(holder.imageview)
        Toast.makeText(context,""+c_id,Toast.LENGTH_LONG).show()

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        holder.button.setOnClickListener {

            var call: Call<Void> =   apiinterface.addtocart(c_id,list.get(position).pname,list.get(position).pprice,list.get(position).pimage,list.get(position).pdes)

            call.enqueue(object: Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    Toast.makeText(context,"Added to Cart", Toast.LENGTH_LONG).show()

                  var call:Call<WishlistModel?>? =  apiinterface.deletefromwishlist(list.get(position).id)
                  call!!.enqueue(object :Callback<WishlistModel?>{
                      override fun onResponse(
                          call: Call<WishlistModel?>,
                          response: Response<WishlistModel?>
                      ) {
                          var i = Intent(context,CartViewActivity::class.java)
                          i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                          context.startActivity(i)
                      }

                      override fun onFailure(call: Call<WishlistModel?>, t: Throwable) {



                      }
                  })





                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(context,"Cart Added Fail", Toast.LENGTH_LONG).show()
                }
            })

        }

    }
}
class MyView3(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textView: TextView = Itemview.findViewById(R.id.txt1)
    var textView2: TextView = Itemview.findViewById(R.id.txt2)
    var textView3: TextView = Itemview.findViewById(R.id.txt3)
    var imageview: PhotoView = Itemview.findViewById(R.id.photo_view)
    var button: Button = Itemview.findViewById(R.id.btncart)

}