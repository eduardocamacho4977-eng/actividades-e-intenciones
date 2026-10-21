package com.example.ejerciciosandroidintents.ejercicio12

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio12ConfigActivity : AppCompatActivity() {

    private val opcionesTamano = arrayOf("Pequeño", "Mediano", "Grande")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio12_config)

        val campoMensaje = findViewById<EditText>(R.id.campoMensajeEj12)
        val spinnerTamano = findViewById<Spinner>(R.id.spinnerTamanoEj12)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarEj12)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesTamano)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTamano.adapter = adapter

        val mensajeActual = intent.getStringExtra("mensaje_actual") ?: ""
        val tamanoActual = intent.getStringExtra("tamano_actual") ?: "Mediano"

        campoMensaje.setText(mensajeActual)
        val posIndex = opcionesTamano.indexOf(tamanoActual)
        if (posIndex >= 0) {
            spinnerTamano.setSelection(posIndex)
        }

        botonGuardar.setOnClickListener {
            val nuevoMensaje = campoMensaje.text.toString()
            val nuevoTamano = spinnerTamano.selectedItem.toString()

            val resultIntent = Intent().apply {
                putExtra("mensaje", nuevoMensaje)
                putExtra("tamano", nuevoTamano)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}