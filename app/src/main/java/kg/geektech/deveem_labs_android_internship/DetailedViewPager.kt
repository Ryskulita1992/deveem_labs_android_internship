package kg.geektech.deveem_labs_android_internship

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kg.geektech.deveem_labs_android_internship.databinding.ItemViewPagerBinding
import kg.geektech.deveem_labs_android_internship.ui.Item
import kg.geektech.youtubeparsing.extensions.loadImage
import kg.geektech.youtubeparsing.extensions.toastText


class DetailedViewPagerAdapter(
    val context: Context, private var lists: Item?,
) : PagerAdapter() {
    private lateinit var list:ArrayList<Item>
    lateinit var binding:ItemViewPagerBinding


//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedViewPagerVH {
//        val v = parent.inflateEx(R.layout.item_view_pager)
//        return DetailedViewPagerVH(v)
//    }
//
//
//    override fun onBindViewHolder(holder: DetailedViewPagerVH, position: Int) {
//        holder.bind(list[position])
//        Log.e("TAG", "onBindViewHolder:$list ")
//        holder.setImageView(list.get(position))
//        Log.e("TAG", "onBindViewHolder: ${holder.setImageView(list.get(position))}")
//        holder.binding.imageViewPager.setOnClickListener {
//            itemClickListener(position)
//        }
//    }
//
//
//    override fun getItemCount(): Int = list.size
//
//    class DetailedViewPagerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val binding = ItemViewPagerBinding.bind(itemView)
//
//        fun bind(item: Item) {
//
//        }
//
//        fun setImageView(item: Item) {
//            Glide.with(itemView.context)
//                .load(item.url1)
//                .into(binding.imageViewPager)
//        }
//    }

    override fun getCount(): Int {
        return list!!.size
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view=LayoutInflater.from(context).inflate(R.layout.item_view_pager,container, false)
        val model= list!![position]
        val image1=model.url1
        var image2=model.url2
        var image3=model.url3
        var image4=model.url4

        binding.imageViewPager.loadImage(image1)
        binding.imageViewPager.setOnClickListener {
            toastText(context, "Image click to next")
        }
        container.addView(view, position)

        return super.instantiateItem(container, position)
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}


