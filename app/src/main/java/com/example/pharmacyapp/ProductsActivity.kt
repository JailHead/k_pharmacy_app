package com.example.pharmacyapp

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmacyapp.models.Product

class ProductsActivity : AppCompatActivity() {

    private lateinit var productListView: ListView
    private lateinit var productImage: ImageView
    private lateinit var productName: TextView
    private lateinit var productDescription: TextView
    private lateinit var productPresentation: TextView
    private lateinit var productCost: TextView

    private lateinit var products: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        productListView = findViewById(R.id.listViewProducts)
        productImage = findViewById(R.id.imageViewProduct)
        productName = findViewById(R.id.textViewProductName)
        productDescription = findViewById(R.id.textViewProductDescription)
        productPresentation = findViewById(R.id.textViewProductPresentation)
        productCost = findViewById(R.id.textViewProductCost)

        // Sample products (images should be in drawable folder)
        products = listOf(
            Product("Paracetamol", "Pain and fever reducer", "Tablet", "$5.00", R.drawable.ic_paracetamol),
            Product("Ibuprofen", "Anti-inflammatory and analgesic", "Capsule", "$6.50", R.drawable.ic_ibuprofen),
            Product("Amoxicillin", "Antibiotic", "Capsule", "$8.00", R.drawable.ic_amoxicillin),
            Product("Omeprazole", "Gastric protector", "Capsule", "$7.25", R.drawable.ic_omeprazole),
            Product("Loratadine", "Antihistamine for allergies", "Tablet", "$4.75", R.drawable.ic_loratadine)
        )

        val adapter = ProductListAdapter(this, products)
        productListView.adapter = adapter

        productListView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedProduct = products[position]
            productImage.setImageResource(selectedProduct.imageResId)
            productName.text = selectedProduct.name
            productDescription.text = selectedProduct.description
            productPresentation.text = "Presentation: ${selectedProduct.presentation}"
            productCost.text = "Cost: ${selectedProduct.cost}"
        }
    }
}