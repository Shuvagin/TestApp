package com.example.turkcell.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.turkcell.data.sourceProduct.local.model.LocalProduct
import com.example.turkcell.databinding.ItemProductBinding

class ProductListAdapter : ListAdapter<LocalProduct, ProductListAdapter.ViewHolder>(MainDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder private constructor(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: LocalProduct) {
            val itemProductBinding = binding as ItemProductBinding
            itemProductBinding.product = product
            itemProductBinding.executePendingBindings()
            itemProductBinding.root.setOnClickListener { navigateToProductDetail(product,itemProductBinding) }
        }

        private fun navigateToProductDetail(product: LocalProduct, binding: ItemProductBinding) {
            val directions = MainFragmentDirections.actionMainFragmentToDetailFragment(product)
            val extra = FragmentNavigatorExtras(
                binding.ivImage to binding.ivImage.transitionName,
                binding.tvName to binding.tvName.transitionName,
                binding.tvPrice to binding.tvPrice.transitionName
            )
            binding.root.findNavController().navigate(directions, extra)
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemProductBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }

    }
}

class MainDiffCallback : DiffUtil.ItemCallback<LocalProduct>() {
    override fun areItemsTheSame(oldItem: LocalProduct, newItem: LocalProduct): Boolean {
        return oldItem.productId == newItem.productId
    }

    override fun areContentsTheSame(oldItem: LocalProduct, newItem: LocalProduct): Boolean {
        return oldItem.name == newItem.name
    }
}