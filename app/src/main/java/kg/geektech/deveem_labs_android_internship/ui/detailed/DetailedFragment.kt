package kg.geektech.deveem_labs_android_internship.ui.detailed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kg.geektech.deveem_labs_android_internship.R
import kg.geektech.deveem_labs_android_internship.databinding.DetailedFragmentBinding
import kg.geektech.deveem_labs_android_internship.ui.Item
import kg.geektech.deveem_labs_android_internship.ui.home.POS
import kg.geektech.youtubeparsing.extensions.loadImage


class DetailedFragment : Fragment(R.layout.detailed_fragment) {
    private lateinit var item: Item
    private var viewModel: DetailedViewModel? = null
    private var _binding: DetailedFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager2
    private var arrayOfList: MutableList<Item> = mutableListOf()
    private var array: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null)
            let {
                item = (arguments?.getSerializable(POS) as Item)
            } else {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailedFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is AppCompatActivity) {
            (activity as AppCompatActivity).setSupportActionBar(binding.toolbarBack)
            (activity as AppCompatActivity?)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
            binding.toolbarBack.setNavigationIcon(R.drawable.ic_back)

            binding.toolbarBack.title = ""
        }

        init()
        back()

    }

    fun init() {
        setData()
        menuClick()
        vgetItemFromViewModel()
        setAdapter()
    }

    fun vgetItemFromViewModel() {
        arrayOfList.add(item)
        setAdapter()

    }
    fun setAdapter() {
//        val adapter = DetailedActivity.IntroPagerAdapter()
        Log.e("TAG", "setAdapter: $arrayOfList")
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
//
//        TabLayoutMediator(binding.tabLayout, binding.photosViewpager) { tab, position ->
//        }.attach()
    }


    fun setData() {
        binding.vpPhoto.loadImage(item.url1)
        binding.viewsAmount.text = item.viewsAmount.toString()
        binding.detailLocation.text = item.location.toString()
        binding.descDetailTv.text = item.itemDesc
        binding.priceTv.text = item.itemsPrice.toString()
        binding.itemTitle.text = item.itemTitle
        binding.dateUpdate.text = item.updateDay
    }
    fun onItemClick(pos: Int) {

        }


    fun back() {
        binding.toolbarBack.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    fun menuClick() {
        binding.toolbarBack.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_favorites -> {
                    // Handle favorite icon press
                    true
                }
                R.id.menu_share -> {
                    // Handle search icon press
                    true
                }
                R.id.menu_more -> {
                    true
                }
                else -> false
            }
        }
    }
}


