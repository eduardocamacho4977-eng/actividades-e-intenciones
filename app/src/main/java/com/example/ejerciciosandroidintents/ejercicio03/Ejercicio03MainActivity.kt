package com.example.ejerciciosandroidintents.ejercicio03

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio03MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio03_main)

        val campoNombre = findViewById<EditText>(R.id.campoNombreEj3)
        val campoEdad = findViewById<EditText>(R.id.campoEdadEj3)
        val botonEnviar = findViewById<Button>(R.id.botonEnviarEj3)

        botonEnviar.setOnClickListener {
            val nombre = campoNombre.text.toString()
            val edad = campoEdad.text.toString().toIntOrNull() ?: 0
            val persona = Persona(nombre, edad)

            val intent = Intent(this, Ejercicio03SegundaActivity::class.java).apply {
                putExtra("persona", persona)
            }
            startActivity(intent)
        }
    }
}