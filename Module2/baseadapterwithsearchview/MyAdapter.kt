package tops.tech.customlistex


import android.content.Context
import android.view.Display.Mode
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(private val context: Context, private val itemList: List<Model>) : BaseAdapter()
{
   /* private val filteredList = ArrayList<Model>()

    init {
        filteredList.addAll(itemList)
    }*/

    val fileteredlist = ArrayList<Model>()

    init
    {
        fileteredlist.addAll(itemList)
    }


    override fun getCount(): Int
    {
        return fileteredlist.size
    }

    override fun getItem(position: Int): Any {
        return fileteredlist[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.design, parent, false)

        var image:ImageView = view.findViewById(R.id.img1)
        var txt1:TextView = view.findViewById(R.id.txtname)
        var txt2:TextView = view.findViewById(R.id.txtnum)


        image.setImageResource(itemList.get(position).image)
        txt1.setText(itemList.get(position).name)
        txt2.setText(itemList.get(position).number)

        val item = fileteredlist[position]
        txt1.text = item.name
        return view
    }

   fun filter(query: String)
    {
        fileteredlist.clear()
        if (query.isEmpty())
        {
            fileteredlist.addAll(itemList)
        } else {
            val lowercaseQuery = query.toLowerCase()
            for (item in itemList) {
                if (item.name.toLowerCase().contains(lowercaseQuery)) {
                    fileteredlist.add(item)
                }
            }
        }
        notifyDataSetChanged()//refresh
    }

    /*fun topsfilter(query:String)
    {
        fileteredlist.clear()

        if(query.isEmpty())
        {
            fileteredlist.addAll(itemList)
        }
        else
        {
            val lowercaseQuery = query.toLowerCase()
            for(item in itemList)
            {
                if (item.name.toLowerCase().contains(lowercaseQuery))
                {
                    fileteredlist.add(item)
                }

            }

        }
    }
*/

}


