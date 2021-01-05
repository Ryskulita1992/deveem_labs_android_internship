package kg.geektech.deveem_labs_android_internship.ui.buildMaterials

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geektech.deveem_labs_android_internship.R

class BuildMaterialsFragment : Fragment() {

    companion object {
        fun newInstance() = BuildMaterialsFragment()
    }

    private lateinit var viewModel: BuildMaterialsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.build_materials_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BuildMaterialsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}