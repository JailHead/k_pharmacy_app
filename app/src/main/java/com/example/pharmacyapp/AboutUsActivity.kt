// STEP 9: AboutUsActivity.kt
package com.example.pharmacyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pharmacyapp.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewAboutUs.text = """
            Welcome to HealthPlus Pharmacy!

            We are committed to providing high-quality medications and personalized services to support your health needs. With a wide range of pharmaceutical products and a friendly professional staff, our mission is to make healthcare accessible and efficient for everyone.

            Contact us:
            Phone: +1-800-123-4567
            Email: contact@healthpluspharmacy.com
            Address: 123 Wellness Blvd, Healthy City, HC 45678
        """.trimIndent()
    }
}