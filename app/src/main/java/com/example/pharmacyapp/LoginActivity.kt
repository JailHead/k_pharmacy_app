package com.example.pharmacyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmacyapp.util.SharedPreferencesManager

class LoginActivity : AppCompatActivity() {

    private lateinit var prefsManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        prefsManager = SharedPreferencesManager(this)

        // Auto-login if already authenticated
        if (prefsManager.isLoggedIn()) {
            startActivity(Intent(this, MainMenuActivity::class.java))
            finish()
        }

        val usernameInput = findViewById<EditText>(R.id.editTextUsername)
        val passwordInput = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<Button>(R.id.buttonLogin)
        val exitButton = findViewById<Button>(R.id.buttonExit)

        loginButton.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            if (username.isNotBlank() && password.isNotBlank()) {
                prefsManager.saveLogin(username, password)
                startActivity(Intent(this, MainMenuActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            }
        }

        exitButton.setOnClickListener {
            finishAffinity() // Closes all activities
        }
    }
}