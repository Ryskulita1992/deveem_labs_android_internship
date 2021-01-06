
package kg.geektech.deveem_labs_android_internship

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.deveem_labs_android_internship.databinding.ItemViewPagerBinding
import kg.geektech.deveem_labs_android_internship.ui.Item
import kg.geektech.youtubeparsing.extensions.inflateEx
import kg.geektech.youtubeparsing.extensions.loadImage

class DetailedViewPagerAdapter():RecyclerView.Adapter<DetailedViewPagerAdapter.PagerVH>(
){
    lateinit var holder: PagerVH



    class PagerVH(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemViewPagerBinding.bind(itemView)
    }

    private  var list : MutableList<Item> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        val v = parent.inflateEx(R.layout.item_view_pager)
        return PagerVH(v)    }

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        this.holder = holder
        val item = list?.get(position)
        holder.binding.imageViewPager.loadImage(item.toString())

    }

    override fun getItemCount(): Int {
     return list?.size!!
    }



}