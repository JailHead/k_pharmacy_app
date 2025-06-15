package com.example.pharmacyapp.util

import android.content.Context
import android.content.SharedPreferences
import com.example.pharmacyapp.models.Recipe
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPreferencesManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("PharmacyPrefs", Context.MODE_PRIVATE)

    fun saveLogin(username: String, password: String) {
        prefs.edit().putString("username", username).putString("password", password).apply()
    }

    fun clearLogin() {
        prefs.edit().clear().apply()
    }

    fun saveRecipe(recipe: Recipe) {
        val gson = Gson()
        val recipeList = getRecipes().toMutableList()
        recipeList.add(recipe)
        prefs.edit().putString("recipes", gson.toJson(recipeList)).apply()
    }

    fun getRecipes(): List<Recipe> {
        val gson = Gson()
        val json = prefs.getString("recipes", "[]")
        val type = object : TypeToken<List<Recipe>>() {}.type
        return gson.fromJson(json, type)
    }

    fun isLoggedIn(): Boolean = prefs.contains("username")
}