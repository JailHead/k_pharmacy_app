// STEP 8: MyRecipesActivity.kt
package com.example.pharmacyapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmacyapp.models.Recipe
import com.example.pharmacyapp.util.SharedPreferencesManager

class MyRecipesActivity : AppCompatActivity() {

    private lateinit var prefsManager: SharedPreferencesManager
    private lateinit var container: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_recipes)

        prefsManager = SharedPreferencesManager(this)
        container = findViewById(R.id.recipesContainer)

        val recipes: List<Recipe> = prefsManager.getRecipes()

        if (recipes.isEmpty()) {
            val emptyText = TextView(this)
            emptyText.text = "No recipes registered."
            container.addView(emptyText)
        } else {
            for (recipe in recipes) {
                val recipeView = TextView(this)
                recipeView.text = """
                    Date: ${recipe.date}
                    SSN: ${recipe.ssn}
                    Name: ${recipe.firstName} ${recipe.lastName}
                    Address: ${recipe.address}
                    Medication: ${recipe.medication} (${recipe.presentation})
                    Phone: ${recipe.phone}
                """.trimIndent()
                recipeView.setPadding(0, 16, 0, 16)
                container.addView(recipeView)
            }
        }
    }
}