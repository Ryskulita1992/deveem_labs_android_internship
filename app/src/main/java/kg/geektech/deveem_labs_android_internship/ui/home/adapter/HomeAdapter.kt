package kg.geektech.deveem_labs_android_internship.ui.home.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.deveem_labs_android_internship.R
import kg.geektech.deveem_labs_android_internship.databinding.ItemHomeBinding
import kg.geektech.deveem_labs_android_internship.ui.Item
import kg.geektech.youtubeparsing.extensions.inflateEx
import kg.geektech.youtubeparsing.extensions.loadImage
import kotlin.reflect.KFunction1

class HomeAdapter(var onItemClick:(Item)-> Unit) :
    RecyclerView.Adapter<HomeAdapter.HomeVH>() {
    lateinit var holder: HomeVH
    private var list: MutableList<Item> = mutableListOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVH {
        val v = parent.inflateEx(R.layout.item_home)
        return HomeVH(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeVH, position: Int) {
        this.holder = holder
        holder.bind(list[position])
        val item = list[position]
        holder.binding.itemsImageView.loadImage(item.url1)
        holder.binding.itemTitle.text=item.itemTitle
        holder.binding.itemPrice.text=item.itemsPrice.toString() +"  "+ item.currency
        holder.binding.price.text= "Цена"
        holder.binding.quantity.text=item.weight
        holder.binding.locationTv.text=item.location

        holder.binding.itemsImageView.setOnClickListener {
            onItemClick(item)
        }
    }


    fun addItem(item: MutableList<Item>) {
        this.list=item
    }
    inner class HomeVH(v: View) : RecyclerView.ViewHolder(v) {
        val binding = ItemHomeBinding.bind(v)

        init {
            itemView.setOnClickListener {
            }
        }

        fun bind(item: Item) {
        }
    }
}


