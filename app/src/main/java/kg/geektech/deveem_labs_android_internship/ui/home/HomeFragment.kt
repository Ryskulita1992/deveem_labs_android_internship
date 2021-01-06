package kg.geektech.deveem_labs_android_internship.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kg.geektech.deveem_labs_android_internship.MainPagerAdapter
import kg.geektech.deveem_labs_android_internship.R
import kg.geektech.deveem_labs_android_internship.databinding.FragmentHomeBinding
import kg.geektech.deveem_labs_android_internship.ui.Item
import kg.geektech.deveem_labs_android_internship.ui.agriculturalTech.AgriculturalTechFragment
import kg.geektech.deveem_labs_android_internship.ui.agrobazaar.AgroBazaarFragment
import kg.geektech.deveem_labs_android_internship.ui.buildMaterials.BuildMaterialsFragment
import kg.geektech.deveem_labs_android_internship.ui.home.adapter.HomeAdapter
import java.util.*

const val POS = "pos"

class HomeFragment() : Fragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var rv: RecyclerView
    private lateinit var adapter: HomeAdapter
    private lateinit var stagerredLM: StaggeredGridLayoutManager
    private lateinit var searchView: SearchView
    private var arrayList: ArrayList<Item>? = null
    private var displayList: ArrayList<Item>? = null
    companion object {
        fun newInstance(arg: String) = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        initViews()
        setAdapter()
        setUpTabs()
        searchClick()
        return view
    }

    private fun initViews() {
        tabLayout = binding.tabLayoutViewPager
        viewPager = binding.viewPager
        rv = binding.rv
        searchView = binding.searchView
    }
    private fun setAdapter() {
        stagerredLM = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        stagerredLM.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS)
        rv.setLayoutManager(stagerredLM)
        adapter = HomeAdapter(this::onClick)
        rv.adapter = adapter
        homeViewModel.init()
        homeViewModel.listItem.observeForever {
            adapter.addItem(it)
            arrayList = it as ArrayList<Item>?
            Log.e("TAG", "setAdapter:$arrayList ")
            displayList = it
            Log.e("TAG", "setAdapter: $displayList")
        }
    }

    fun onClick(pos: Item) {
        var pos = pos
        val result = Bundle()
        result.putSerializable(POS, pos)
        if (findNavController().currentDestination?.id == R.id.navigation_home) {
            findNavController().navigate(R.id.action_navigation_home_to_navigation_detailed, result)
            Log.e("TAG", "onClick: $result", )
        }
    }

    private fun setUpTabs() {
        val adapter = MainPagerAdapter(requireActivity().supportFragmentManager)
        adapter.addFragment(AgroBazaarFragment(), "Агробазар")
        adapter.addFragment(AgriculturalTechFragment(), "Сельхоз техника")
        adapter.addFragment(BuildMaterialsFragment(), "Строительный атериал")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_vector_bazaar)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_vector_selhoz)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_vector_buil_mat)
    }

    private fun searchClick() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText!!.isNotEmpty()) {
                    displayList?.clear()
                    val search = newText.toLowerCase(Locale.getDefault())
                    arrayList?.forEach {
                        if (it.itemTitle!!.toLowerCase(Locale.getDefault()).contains(search))
                            displayList?.add(it)
                        rv.adapter!!.notifyDataSetChanged() }
                } else {
                    displayList?.clear()
                    displayList?.addAll(arrayList!!)
                    rv.adapter!!.notifyDataSetChanged()
                }
                return true
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}