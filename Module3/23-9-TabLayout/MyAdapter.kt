package tops.tech.tablayoutex

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyAdapter(var context: Context,var fm:FragmentManager) : FragmentStatePagerAdapter(fm)
{
    var listFragment: ArrayList<Fragment> = ArrayList<Fragment>()
    var listtitle:   ArrayList<String> = ArrayList<String>()

    override fun getCount(): Int
    {
        return listFragment.size
    }

    override fun getItem(position: Int): Fragment
    {
        return listFragment.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return listtitle.get(position)
    }

    fun mydata(fragment: Fragment,title:String)
    {
        listtitle.add(title)
        listFragment.add(fragment)
    }



}