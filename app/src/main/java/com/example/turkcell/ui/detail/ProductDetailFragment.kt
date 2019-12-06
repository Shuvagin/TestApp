package com.example.turkcell.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.turkcell.R
import com.example.turkcell.databinding.FragmentProductDetailBinding
import com.example.turkcell.di.injector
import com.example.turkcell.di.util.navGraphViewModel

/**
 * A simple [Fragment] subclass.
 */
class ProductDetailFragment : Fragment() {

    lateinit var binding: FragmentProductDetailBinding
//    private val mainViewModel by navGraphViewModel(R.id.nav_graph) {
//        injector.mainViewModel
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_product_detail,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        mainViewModel.selectedProductItem.observe(viewLifecycleOwner) {
//            binding.product = it
//        }
    }

}
