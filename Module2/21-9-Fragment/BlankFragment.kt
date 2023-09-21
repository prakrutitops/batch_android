package tops.tech.fragmentex1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class BlankFragment : Fragment() {

    lateinit var txt1:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       var view =inflater.inflate(R.layout.fragment_blank, container, false)

        txt1 = view.findViewById(R.id.txt1)

        txt1.setOnClickListener {

            //Toast.makeText(requireActivity(), "Success", Toast.LENGTH_SHORT).show()

            var b2 = BlankFragment2()
            var fm:FragmentManager = requireFragmentManager()
            var ft:FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.frmid,b2).commit()


        }


        return view

    }


}