package com.example.firebasecrudex

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder

class MyAdapter(options: FirebaseRecyclerOptions<Model>) : FirebaseRecyclerAdapter<Model, myviewholder>(options)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder
    {
        val view: View = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int, model: Model)
    {
        holder.name.setText(model.myname)
        holder.email.setText(model.myemail)
        holder.pass.setText(model.mypass)

        holder.edit.setOnClickListener {

            var dialogplus = DialogPlus.newDialog(holder.edit.context)
                .setContentHolder(ViewHolder(R.layout.dialogcontent))
                .setExpanded(true, 1100)
                .create()
            val myview = dialogplus.holderView
            val edt1 = myview.findViewById<EditText>(R.id.edt1)
            val edt2 = myview.findViewById<EditText>(R.id.edt2)
            val edt3 = myview.findViewById<EditText>(R.id.edt3)
            val submit = myview.findViewById<Button>(R.id.btnupdate)


            edt1.setText(model.myname)
            edt2.setText(model.myemail)
            edt3.setText(model.mypass)

            submit.setOnClickListener {

                val map: MutableMap<String, Any> = HashMap()
                map["myname"] = edt1.text.toString()
                map["myemail"] = edt2.text.toString()
                map["mypass"] = edt3.text.toString()

                FirebaseDatabase.getInstance().getReference().child("android")
                    .child(getRef(position).key!!).updateChildren(map)
                    .addOnSuccessListener {
                        Toast.makeText(holder.edit.context,"Updated", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(holder.edit.context,"Error",Toast.LENGTH_LONG).show()
                    }


            }

            dialogplus.show()


        }
        holder.delete.setOnClickListener {

            var alert = AlertDialog.Builder(holder.delete.context)
            alert.setTitle("Are you sure you want to delete?")
            alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                FirebaseDatabase.getInstance().getReference().child("android")
                    .child(getRef(position).getKey()!!)
                    .removeValue()

                notifyItemRangeChanged(position,0)


            })
            alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                dialogInterface.cancel()

            })
            alert.show()

        }

    }

}
class myviewholder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView
    var pass: TextView
    var email: TextView
    var edit: ImageView
    var delete: ImageView



    init
    {

        name = itemView.findViewById(R.id.txt1)
        email = itemView.findViewById(R.id.txt2)
        pass = itemView.findViewById(R.id.txt3)
        edit = itemView.findViewById(R.id.i1)
        delete = itemView.findViewById(R.id.i2)


    }
}