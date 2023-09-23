package tops.tech.tablayoutex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast


class ChatFragment : Fragment()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_chat, container, false)

        listView = view.findViewById(R.id.list)
        list = ArrayList()

        list.add(Model(R.drawable.a,"A1","999999999"))
        list.add(Model(R.drawable.b,"A2","888888888"))
        list.add(Model(R.drawable.c,"B1","777777777"))
        list.add(Model(R.drawable.d,"B2","666666666"))
        list.add(Model(R.drawable.a,"C1","999999999"))
        list.add(Model(R.drawable.b,"C2","888888888"))
        list.add(Model(R.drawable.c,"D1","777777777"))
        list.add(Model(R.drawable.d,"D2","666666666"))

        var myAdapter = MyAdapter2(requireActivity(),list)
        listView.adapter=myAdapter

        listView.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(requireActivity(),""+position,Toast.LENGTH_LONG).show()


        }

        return view
    }


}