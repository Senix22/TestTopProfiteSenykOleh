package com.senix22.testtopprofite.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.senix22.testtopprofite.R
import com.senix22.testtopprofite.ui.repository.ProductModel
import kotlinx.android.synthetic.main.list_item.view.*

class UserAdapter() : ListAdapter<ProductModel, RecyclerView.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductViewHolder).bind(getItem(position))

    }
}

class ProductViewHolder(private val item: View) : RecyclerView.ViewHolder(item) {
    fun bind(productModel: ProductModel) {
        item.product_title.text = productModel.productTitle
        Glide.with(itemView)
            .load(productModel.productUrl)
            .into(itemView.photo)
    }
}

val diffUtil = object : DiffUtil.ItemCallback<ProductModel>() {

    override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel) =
        oldItem == newItem

}