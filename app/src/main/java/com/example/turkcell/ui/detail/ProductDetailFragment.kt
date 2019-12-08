package com.example.turkcell.ui.detail

import android.content.Context
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.transition.doOnEnd
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
        }.doOnEnd {
            expandSizeText()
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
        setOnBackPressedAction()
        mainViewModel.productItemId.value = args.product.productId
    }

    private fun setOnBackPressedAction() {
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            shrinkSizeTextThenExit()
        }
    }

    private fun expandSizeText() {
        binding.tvName.animate()
            .scaleX(MAX_SCALE_SIZE)
            .scaleY(MAX_SCALE_SIZE)
            .start()
    }

    private fun shrinkSizeTextThenExit() {
        binding.tvName.animate()
            .scaleY(NORMAL_SCALE_SIZE)
            .scaleX(NORMAL_SCALE_SIZE)
            .withEndAction { findNavController().popBackStack() }
            .start()
    }

    companion object {
        const val MAX_SCALE_SIZE = 1.5f
        const val NORMAL_SCALE_SIZE = 1f
        const val ANIMATION_EXIT_DURATION = 100L
    }
}
