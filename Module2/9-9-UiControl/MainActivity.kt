package tops.tech.uicontrols

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import tops.tech.uicontrols.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener,
    RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    var city = arrayOf("Rajkot","Ahmedabad","Baroda")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.rd1.setOnCheckedChangeListener(this)
        binding.rd2.setOnCheckedChangeListener(this)
        binding.rg.setOnCheckedChangeListener(this)

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,city)
        binding.spin.adapter=adapter
        binding.spin.setOnItemSelectedListener(this)

        var adapter2 = ArrayAdapter(applicationContext,android.R.layout.select_dialog_item,city)
        binding.a1.threshold=1
        binding.a1.setAdapter(adapter2)

        binding.rate1.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->

            Toast.makeText(applicationContext,""+ratingBar.rating,Toast.LENGTH_LONG).show()

        }
        binding.web1.loadUrl("https://www.tops-int.com")


    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        if(binding.rd1.isChecked)
        {
            Toast.makeText(applicationContext,"Male",Toast.LENGTH_SHORT).show()
        }
        if(binding.rd2.isChecked)
        {
            Toast.makeText(applicationContext,"Female",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Toast.makeText(applicationContext,""+city[position],Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}