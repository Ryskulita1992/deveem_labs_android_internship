package kg.geektech.deveem_labs_android_internship.ui.agrobazaar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.geektech.deveem_labs_android_internship.R

class AgroBazaarFragment : Fragment() {

    companion object {
        fun newInstance() = AgroBazaarFragment()
    }

    private lateinit var viewModel: AgroBazaarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.agro_bazaar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AgroBazaarViewModel::class.java)
        // TODO: Use the ViewModel
    }

}