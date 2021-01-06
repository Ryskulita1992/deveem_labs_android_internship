package kg.geektech.deveem_labs_android_internship.ui.detailed

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import kg.geektech.deveem_labs_android_internship.DetailedViewPagerAdapter
import kg.geektech.deveem_labs_android_internship.R
import kg.geektech.deveem_labs_android_internship.databinding.DetailedFragmentBinding
import kg.geektech.deveem_labs_android_internship.ui.Item
import kg.geektech.deveem_labs_android_internship.ui.home.POS
import kg.geektech.youtubeparsing.extensions.loadImage
import kg.geektech.youtubeparsing.extensions.toastText

class DetailedFragment : Fragment(R.layout.detailed_fragment) {
    private lateinit var item: Item
    private var viewModel: DetailedViewModel? = null
    private var _binding: DetailedFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPager: ViewPager2

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
            (activity as AppCompatActivity).setSupportActionBar(binding.detailedToolbar)
            binding.detailedToolbar.title = ""
        }
        init()
        back()

    }

    fun init() {
        val adapter = DetailedViewPagerAdapter()
        // viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        // viewPager.adapter = adapter
        setData()
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



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //get item id to handle item clicks
        var itemview = item!!.itemId
        when (itemview) {
            R.id.menu_favorites ->
                toastText(requireContext(), "Menu fav")
            R.id.menu_share ->
                toastText(requireContext(), "Menu share")
            R.id.menu_more ->
                toastText(requireContext(), "Menu more")
        }
            return super.onOptionsItemSelected(item)
    }

    fun back() {
        binding.detailedToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()

        }
    }
}


