package tops.tech.prefrencescreenex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity

class MainActivity2 : PreferenceActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main2)
        addPreferencesFromResource(R.xml.details)
    }
}