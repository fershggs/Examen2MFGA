package com.example.examen2mfga

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.examen2mfga.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSesion.setOnClickListener {
            val password = binding.edtContraseA.text.toString()

            if (password == "abc123") {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }else {
                // La contraseña es incorrecta, mostrar Toast
                Toast.makeText(this, "No es correcta la contraseña", Toast.LENGTH_SHORT).show()
            }
        }

    }
}