package com.example.pharmacyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmacyapp.util.SharedPreferencesManager

class MainMenuActivity : AppCompatActivity() {

    private lateinit var prefsManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        prefsManager = SharedPreferencesManager(this)

        val refillButton = findViewById<Button>(R.id.buttonRefill)
        val productsButton = findViewById<Button>(R.id.buttonProducts)
        val myRecipesButton = findViewById<Button>(R.id.buttonMyRecipes)
        val aboutUsButton = findViewById<Button>(R.id.buttonAboutUs)
        val logoutButton = findViewById<Button>(R.id.buttonLogout)

        refillButton.setOnClickListener {
            startActivity(Intent(this, RefillActivity::class.java))
        }

        productsButton.setOnClickListener {
            startActivity(Intent(this, ProductsActivity::class.java))
        }

        myRecipesButton.setOnClickListener {
            startActivity(Intent(this, MyRecipesActivity::class.java))
        }

        aboutUsButton.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        }

        logoutButton.setOnClickListener {
            prefsManager.clearLogin()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}