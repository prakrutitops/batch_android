package tops.tech.retrofitcrudex

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Myadapter(var context: Context,var list: List<Model>):RecyclerView.Adapter<MyView>()
{
    lateinit var apiinterface: Apiinterface

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
        var id = list.get(position).id
        holder.textView.setText(list.get(position).p_name)
        holder.textView2.setText(list.get(position).p_price)
        holder.textView3.setText(list.get(position).p_des)

        apiinterface = ApiClient.getretrofit().create(Apiinterface::class.java)

        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("Select Operations?")
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                var i = Intent(context,UpdateActivity::class.java)
                i.putExtra("id",list.get(position).id)
                i.putExtra("name",list.get(position).p_name)
                i.putExtra("price",list.get(position).p_price)
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)



            })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

              var call: Call<Model?>? = apiinterface.deletedata(id)
              call!!.enqueue(object :Callback<Model?>
              {
                  override fun onResponse(call: Call<Model?>, response: Response<Model?>)
                  {
                        Toast.makeText(context,"Product Deleted",Toast.LENGTH_LONG).show()

                      var i = Intent(context,ViewActivity::class.java)
                      i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                      context.startActivity(i)

                  }

                  override fun onFailure(call: Call<Model?>, t: Throwable)
                  {
                    //Toast.makeText(context,"Error",Toast.LENGTH_LONG).show()
                  }
                 // context.startActivity(Intent(context, View::class.java))


              })

            })
            alert.show()

        }
    }
}
class MyView(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textView: TextView = Itemview.findViewById(R.id.txt1)
    var textView2: TextView = Itemview.findViewById(R.id.txt2)
    var textView3: TextView = Itemview.findViewById(R.id.txt3)

}