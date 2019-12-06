package com.example.turkcell.ui.main

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.turkcell.databinding.MainFragmentBinding
import com.example.turkcell.di.injector
import com.example.turkcell.di.util.activityViewModel

class MainFragment : Fragment() {

    private lateinit var binding: MainFragmentBinding
    private lateinit var productAdapter: ProductListAdapter
    private val mainViewModel by activityViewModel {
        injector.mainViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false).apply {
            viewmodel = mainViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupProductAdapter()
    }

    private fun setupProductAdapter() {
        productAdapter = ProductListAdapter()
        binding.rv.apply {
            adapter = productAdapter
            layoutManager =
                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
                } else {
                    StaggeredGridLayoutManager(4, RecyclerView.VERTICAL)
                }
            postponeEnterTransition()
            viewTreeObserver.addOnPreDrawListener { startPostponedEnterTransition(); true }
        }
        mainViewModel.listProducts.observe(viewLifecycleOwner) {
            productAdapter.submitList(it)
        }
    }
}
