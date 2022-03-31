package org.d3if2143.luassegitiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if2143.luassegitiga.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { hitungSegitiga() }
    }

    private fun hitungSegitiga() {
        val alas = binding.alasEditText.text.toString()
        if (TextUtils.isEmpty(alas)) {
            Toast.makeText(this, R.string.alas_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val tinggi = binding.tinggiEditText.text.toString()
        if (TextUtils.isEmpty(tinggi)) {
            Toast.makeText(this, R.string.tinggi_invalid, Toast.LENGTH_LONG).show()
            return
        }

        val hasil = 0.5 * alas.toDouble() * tinggi.toDouble()

        binding.hasil.text = getString(R.string.hasil_x, hasil)
    }
}