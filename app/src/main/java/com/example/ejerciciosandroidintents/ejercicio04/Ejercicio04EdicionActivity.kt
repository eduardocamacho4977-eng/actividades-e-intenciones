package com.example.ejerciciosandroidintents.ejercicio04

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio04EdicionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio04_edicion)

        val campoNombre = findViewById<EditText>(R.id.campoNombreEj4)
        val campoEdad = findViewById<EditText>(R.id.campoEdadEj4)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarEj4)

        val nombreActual = intent.getStringExtra("nombre") ?: ""
        val edadActual = intent.getIntExtra("edad", 0)

        campoNombre.setText(nombreActual)
        campoEdad.setText(edadActual.toString())

        botonGuardar.setOnClickListener {
            val nuevoNombre = campoNombre.text.toString()
            val nuevaEdad = campoEdad.text.toString().toIntOrNull() ?: edadActual

            val resultIntent = Intent().apply {
                putExtra("nombre", nuevoNombre)
                putExtra("edad", nuevaEdad)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}