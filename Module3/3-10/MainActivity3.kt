package tops.tech.prefrencescreenex

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class MainActivity3 : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    companion object
    {
        lateinit var txt1:TextView
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        txt1 = findViewById(R.id.txt1)
        btn1.setOnClickListener {

            var d1 = MyDatePicker()
            d1.show(supportFragmentManager,"select date")

        }
        btn2.setOnClickListener {
            var d1 = MyTimePicker()
            d1.show(supportFragmentManager,"select time")
        }

    }
}

class MyDatePicker : DialogFragment(), DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var c = Calendar.getInstance()
        var date = c.get(Calendar.DATE)
        var month = c.get(Calendar.DAY_OF_MONTH)
        var year = c.get(Calendar.YEAR)

        return DatePickerDialog(requireActivity(), this, year, month, date)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        MainActivity3.txt1.setText("$dayOfMonth - $month - $year")
    }
}


class MyTimePicker : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var c = Calendar.getInstance()
        var hour = c.get(Calendar.HOUR_OF_DAY)
        var minute = c.get(Calendar.MINUTE)


        return TimePickerDialog(requireActivity(), this, hour,minute,false)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int)
    {
        MainActivity3.txt1.setText("$hourOfDay : $minute")
    }


}