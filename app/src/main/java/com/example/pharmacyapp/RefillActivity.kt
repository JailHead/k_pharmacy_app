package com.example.pharmacyapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmacyapp.models.Recipe
import com.example.pharmacyapp.util.SharedPreferencesManager

class RefillActivity : AppCompatActivity() {

    private lateinit var prefsManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_refill)

        prefsManager = SharedPreferencesManager(this)

        val date = findViewById<EditText>(R.id.editTextDate)
        val ssn = findViewById<EditText>(R.id.editTextSSN)
        val firstName = findViewById<EditText>(R.id.editTextFirstName)
        val lastName = findViewById<EditText>(R.id.editTextLastName)
        val address = findViewById<EditText>(R.id.editTextAddress)
        val phone = findViewById<EditText>(R.id.editTextPhone)

        val medicationSpinner = findViewById<Spinner>(R.id.spinnerMedication)
        val presentationSpinner = findViewById<Spinner>(R.id.spinnerPresentation)
        val registerButton = findViewById<Button>(R.id.buttonRegister)
        val cancelButton = findViewById<Button>(R.id.buttonCancel)

        val medications = listOf("Ibuprofen", "Paracetamol", "Amoxicillin", "Omeprazole", "Loratadine")
        val presentations = listOf("Tablets", "Syrup", "Injection")

        medicationSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, medications)
        presentationSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, presentations)

        registerButton.setOnClickListener {
            val recipe = Recipe(
                date.text.toString(),
                ssn.text.toString(),
                firstName.text.toString(),
                lastName.text.toString(),
                address.text.toString(),
                medicationSpinner.selectedItem.toString(),
                presentationSpinner.selectedItem.toString(),
                phone.text.toString()
            )

            prefsManager.saveRecipe(recipe)
            Toast.makeText(this, "Recipe registered successfully", Toast.LENGTH_SHORT).show()
            finish() // Return to menu
        }

        cancelButton.setOnClickListener {
            finish() // Return to menu
        }
    }
}