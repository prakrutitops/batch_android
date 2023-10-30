package tops.tech.roomdbex.Adapter

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
import androidx.room.Room
import com.example.roomdb.globalVariables.GlobalVariables
import tops.tech.roomdbex.Activity.AdduserActivity
import tops.tech.roomdbex.Database.MyDatabase
import tops.tech.roomdbex.Entity.User
import tops.tech.roomdbex.R

class MyAdapter(var context:Context,var list:MutableList<User>) :RecyclerView.Adapter<Myview>()
{
    var db: MyDatabase? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview {

        var layout = LayoutInflater.from(parent.context)
        db = Room.databaseBuilder(parent.getContext(), MyDatabase::class.java, "myDatabase").allowMainThreadQueries().build()
        var view = layout.inflate(R.layout.design,parent,false)
        return Myview(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: Myview, position: Int)
    {
        holder.txt1.setText(list.get(position).name)
        holder.txt2.setText(list.get(position).number)

        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("Select Operations?")
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                GlobalVariables.id=list[position].id
                GlobalVariables.name=list[position].name
                GlobalVariables.number=list[position].number
                GlobalVariables.updateFlag = "update"

                var i = Intent(context, AdduserActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context!!.startActivity(i)





            })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

                deleteuser(list.get(position).id)
                list.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, list.size)


            })
            alert.show()

        }
    }

    fun deleteuser(id:Int)
    {
        val user = User()
        user.id = id
        db!!.daoClass().deletedata(user)
        Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show()
    }

}
class Myview(itemview:View) : RecyclerView.ViewHolder(itemview)
{
    var txt1:TextView = itemview.findViewById(R.id.txt1)
    var txt2:TextView = itemview.findViewById(R.id.txt2)
}



