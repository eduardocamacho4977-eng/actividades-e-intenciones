package com.example.ejerciciosandroidintents.ejercicio13

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio13EditarNombreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio13_editar_nombre)

        val campoNombre = findViewById<EditText>(R.id.campoNombreEj13)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarNombreEj13)

        val nombreActual = intent.getStringExtra("nombre_actual") ?: ""
        campoNombre.setText(nombreActual)

        botonGuardar.setOnClickListener {
            val nuevoNombre = campoNombre.text.toString()
            val resultIntent = Intent().apply {
                putExtra("nuevo_nombre", nuevoNombre)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}