package com.example.ejerciciosandroidintents.ejercicio01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio01MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01_main)

        val campoTexto = findViewById<EditText>(R.id.campoTextoEj1)
        val botonEnviar = findViewById<Button>(R.id.botonEnviarEj1)

        botonEnviar.setOnClickListener {
            val mensaje = campoTexto.text.toString()
            val intent = Intent(this, Ejercicio01SegundaActivity::class.java).apply {
                putExtra("mensaje", mensaje)
            }
            startActivity(intent)
        }
    }
}