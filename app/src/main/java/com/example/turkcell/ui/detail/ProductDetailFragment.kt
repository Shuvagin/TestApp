package com.example.turkcell.ui.detail

import android.content.Context
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.turkcell.databinding.FragmentProductDetailBinding
import com.example.turkcell.di.injector
import com.example.turkcell.util.activityViewModel

/**
 * A simple [Fragment] subclass.
 */
class ProductDetailFragment : Fragment() {

    private val args: ProductDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentProductDetailBinding
    private val mainViewModel by activityViewModel {
        injector.mainViewModel
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        TransitionInflater.from(context).inflateTransition(android.R.transition.move).apply {
            sharedElementEnterTransition = this
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false).apply {
            product = args.product
            viewmodel = mainViewModel
            lifecycleOwner = viewLifecycleOwner
            executePendingBindings()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.productItemId.value = args.product.productId
    }
}
