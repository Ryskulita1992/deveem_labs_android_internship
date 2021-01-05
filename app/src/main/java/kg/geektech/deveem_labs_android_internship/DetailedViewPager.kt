
package kg.geektech.deveem_labs_android_internship

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kg.geektech.deveem_labs_android_internship.ui.Item

class DetailedViewPager(fragmentManager: FragmentManager, ):FragmentPagerAdapter(
    fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
){
    private val list = ArrayList<Item>()
    private val mFragment = ArrayList<Fragment>()



    override fun getCount(): Int {
        return mFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragment.get(position)
    }
    fun  addFragment(item: Item){
        list.add(item)

    }



}