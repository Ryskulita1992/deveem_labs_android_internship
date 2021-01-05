package kg.geektech.deveem_labs_android_internship.ui.agriculturalTech

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geektech.deveem_labs_android_internship.R

class AgriculturalTechFragment : Fragment() {

    companion object {
        fun newInstance() = AgriculturalTechFragment()
    }

    private lateinit var viewModel: AgriculturalTechViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.agricultural_tech_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AgriculturalTechViewModel::class.java)
        // TODO: Use the ViewModel
    }

}