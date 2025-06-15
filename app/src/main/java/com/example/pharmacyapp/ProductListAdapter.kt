package com.example.pharmacyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.pharmacyapp.models.Product

class ProductListAdapter(context: Context, private val products: List<Product>) :
    ArrayAdapter<Product>(context, 0, products) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        }

        val product = products[position]

        val imageView = view!!.findViewById<ImageView>(R.id.imageViewItem)
        val nameView = view.findViewById<TextView>(R.id.textViewItemName)

        imageView.setImageResource(product.imageResId)
        nameView.text = product.name

        return view
    }
}