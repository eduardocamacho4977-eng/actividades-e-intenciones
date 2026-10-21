package com.example.ejerciciosandroidintents.ejercicio07

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio07EditarPerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio07_editar)

        val campoNombre = findViewById<EditText>(R.id.campoNombreEj7)
        val campoCorreo = findViewById<EditText>(R.id.campoCorreoEj7)
        val campoEdad = findViewById<EditText>(R.id.campoEdadEj7)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarEj7)

        val nombreActual = intent.getStringExtra("nombre") ?: ""
        val correoActual = intent.getStringExtra("correo") ?: ""
        val edadActual = intent.getIntExtra("edad", 0)

        campoNombre.setText(nombreActual)
        campoCorreo.setText(correoActual)
        campoEdad.setText(edadActual.toString())

        botonGuardar.setOnClickListener {
            val nuevoNombre = campoNombre.text.toString()
            val nuevoCorreo = campoCorreo.text.toString()
            val nuevaEdad = campoEdad.text.toString().toIntOrNull() ?: edadActual

            val resultIntent = Intent().apply {
                putExtra("nombre", nuevoNombre)
                putExtra("correo", nuevoCorreo)
                putExtra("edad", nuevaEdad)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}