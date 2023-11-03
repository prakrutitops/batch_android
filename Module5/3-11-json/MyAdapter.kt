package tops.tech.jsonparsingex8.Activity



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tops.tech.jsonparsingex8.R

//Press alt+Enter
class MyAdapter(var context:Context,var list:MutableList<DashboardModel>) : RecyclerView.Adapter<MyView>()
{

    //inflate your layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.design_dashboard,parent,false)
        return MyView(view)
    }

    //set the data from model to design
    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.image.setImageResource(list.get(position).image)
        holder.txt.setText(list.get(position).text)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

}

//whatever control you have inside your design file
class MyView(itemview: View) : RecyclerView.ViewHolder(itemview)
{

    var image:ImageView = itemview.findViewById(R.id.img)
    var txt:TextView = itemview.findViewById(R.id.txt1)




}