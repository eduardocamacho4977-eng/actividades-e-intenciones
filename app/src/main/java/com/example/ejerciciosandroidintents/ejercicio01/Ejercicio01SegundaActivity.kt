package com.example.ejerciciosandroidintents.ejercicio01

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio01SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio01_segunda)

        val textoRecibido = findViewById<TextView>(R.id.textoRecibidoEj1)
        val mensaje = intent.getStringExtra("mensaje") ?: ""
        textoRecibido.text = mensaje
    }
}