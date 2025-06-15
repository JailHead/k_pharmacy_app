package com.example.pharmacyapp.models

data class Product(
    val name: String,
    val description: String,
    val presentation: String,
    val cost: String,
    val imageResId: Int
)