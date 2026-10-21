package com.example.ejerciciosandroidintents.ejercicio08

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio08EditarContactoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio08_editar)

        val campoNombre = findViewById<EditText>(R.id.campoNombreEj8)
        val campoTelefono = findViewById<EditText>(R.id.campoTelefonoEj8)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarEj8)

        val nombreActual = intent.getStringExtra("nombre") ?: ""
        val telefonoActual = intent.getStringExtra("telefono") ?: ""

        campoNombre.setText(nombreActual)
        campoTelefono.setText(telefonoActual)

        botonGuardar.setOnClickListener {
            val nuevoNombre = campoNombre.text.toString()
            val nuevoTelefono = campoTelefono.text.toString()

            val resultIntent = Intent().apply {
                putExtra("nombre", nuevoNombre)
                putExtra("telefono", nuevoTelefono)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}