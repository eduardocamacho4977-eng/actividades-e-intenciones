package com.example.ejerciciosandroidintents.ejercicio02

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio02SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02_segunda)

        val campoMensaje = findViewById<EditText>(R.id.campoMensajeEj2)
        val botonDevolver = findViewById<Button>(R.id.botonDevolverEj2)

        botonDevolver.setOnClickListener {
            val mensaje = campoMensaje.text.toString()
            val resultIntent = Intent().apply {
                putExtra("mensaje_devuelto", mensaje)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}