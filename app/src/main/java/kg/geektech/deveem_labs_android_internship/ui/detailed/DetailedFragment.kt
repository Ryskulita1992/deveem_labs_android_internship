package kg.geektech.deveem_labs_android_internship.ui.detailed

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import kg.geektech.deveem_labs_android_internship.DetailedViewPager
import kg.geektech.deveem_labs_android_internship.R
import kg.geektech.deveem_labs_android_internship.databinding.DetailedFragmentBinding
import kg.geektech.deveem_labs_android_internship.ui.Item
import kg.geektech.deveem_labs_android_internship.ui.detailed.adapter.DetailedAdapter
import kg.geektech.deveem_labs_android_internship.ui.home.POS

class DetailedFragment : Fragment(R.layout.detailed_fragment) {
    private lateinit var item: Item
    private lateinit var viewModel: DetailedViewModel
    private var _binding: DetailedFragmentBinding? = null
    private val binding get() = _binding!!
    var sampleImages= ArrayList<Item>()
    var mFragment= ArrayList<Fragment>()
    private lateinit var viewPager: ViewPager
    private lateinit var rv: RecyclerView
    private lateinit var adapter: DetailedAdapter
    private var arrayList: ArrayList<Item>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null)
            let {
                item = arguments?.getSerializable(POS) as Item
             //   viewModel.fetchPlaylistVideo(list?.id)
            Log.e("TAG", "onCreate: detailed fragment $item")
            }else{

            }
    }
    companion object {
        fun newInstance(item: Item)= DetailedFragment().apply{
            var fragment: DetailedFragment? = null
            if (item != null) {
                var bundle: Bundle? = null
                bundle?.putParcelable("item", item)
                fragment?.arguments = bundle
            }
            return fragment!!;
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
        init()

    }
    fun init() {
        viewPager=binding.vpPhoto
        val adapter = DetailedViewPager(requireActivity().supportFragmentManager)
        adapter.addFragment(item)
        Log.e("TAG", "init: $item", )
        viewPager.adapter = adapter
        binding.tabLayoutViewPager.setupWithViewPager(viewPager, true)
        binding.vpPhoto.currentItem
        adapter.notifyDataSetChanged()
        setData()

    }
    fun setData(){
        binding.viewsAmount.text=item.viewsAmount.toString()
        binding.detailLocation.text=item.location.toString()
        binding.detailUpdate.text=item.updateDay.toString()
        binding.descDetailTv.text=item.itemDesc
        binding.priceTv.text=item.itemsPrice.toString()
        binding.itemTitle.text=item.itemTitle
    }
}