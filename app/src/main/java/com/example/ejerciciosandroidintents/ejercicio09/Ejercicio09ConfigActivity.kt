package com.example.ejerciciosandroidintents.ejercicio09

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio09ConfigActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio09_config)

        val campoMensaje = findViewById<EditText>(R.id.campoMensajeEj9)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarEj9)

        val mensajeActual = intent.getStringExtra("mensaje_actual") ?: ""
        campoMensaje.setText(mensajeActual)

        botonGuardar.setOnClickListener {
            val nuevoTexto = campoMensaje.text.toString()
            val resultIntent = Intent().apply {
                putExtra("nuevo_mensaje", nuevoTexto)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}