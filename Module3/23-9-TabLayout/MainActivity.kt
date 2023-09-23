package tops.tech.tablayoutex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.vp)
        setuppager()

        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)

    }

    private fun setuppager()
    {

            var adapter = MyAdapter(applicationContext,supportFragmentManager)
            adapter.mydata(ChatFragment(),"CHAT")
            adapter.mydata(StatusFragment(),"STATUS")
            adapter.mydata(CallFragment(),"CALL")
            viewPager.adapter=adapter
    }
}