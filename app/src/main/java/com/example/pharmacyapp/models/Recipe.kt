package com.example.pharmacyapp.models

data class Recipe(
    val date: String,
    val ssn: String,
    val firstName: String,
    val lastName: String,
    val address: String,
    val medication: String,
    val presentation: String,
    val phone: String
)