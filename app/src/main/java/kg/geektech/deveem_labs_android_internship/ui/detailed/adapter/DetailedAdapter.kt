package kg.geektech.deveem_labs_android_internship.ui.detailed.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.deveem_labs_android_internship.R
import kg.geektech.deveem_labs_android_internship.databinding.ItemHomeBinding
import kg.geektech.deveem_labs_android_internship.ui.Item
import kg.geektech.youtubeparsing.extensions.inflateEx
import kg.geektech.youtubeparsing.extensions.loadImage

class DetailedAdapter() :
    RecyclerView.Adapter<DetailedAdapter.DetailedVH>() {
    lateinit var holder: DetailedVH
    private var list: MutableList<Item> = mutableListOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedVH {
        val v = parent.inflateEx(R.layout.item_home)
        return DetailedVH(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DetailedVH, position: Int) {
        this.holder = holder
        holder.bind(list[position])
        val item = list[position]
        holder.binding.itemsImageView.loadImage("")
        holder.binding.itemTitle.text=item.itemTitle
        holder.binding.itemPrice.text=item.itemsPrice.toString() +"  "+ item.currency
        holder.binding.price.text= "Цена"
        holder.binding.quantity.text=item.weight
        holder.binding.locationTv.text=item.location
    }

    fun addItems(items: MutableList<Item>) {
        list.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: MutableList<Item>) {
        this.list=item
    }

    fun itemRemove(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
        Log.v("DELETED_POSITION_AT", "$position")
    }

    fun add(list: Item) {


    }

    inner class DetailedVH(v: View) : RecyclerView.ViewHolder(v) {
        val binding = ItemHomeBinding.bind(v)

        init {
            itemView.setOnClickListener {

            }

        }

        fun bind(item: Item) {
//            binding.itemDetailedImage.item_playlist_image.loadImage(item.snippet?.thumbnails?.medium?.url)
//            binding.itemDetailedVideoTitle.item_video_title.text = item.snippet?.title
            Log.e("TAG", "bind: ")


        }
    }
}


