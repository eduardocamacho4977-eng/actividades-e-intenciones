package com.example.ejerciciosandroidintents.ejercicio05

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio05BienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio05_bienvenida)

        val textoBienvenida = findViewById<TextView>(R.id.textoBienvenidaEj5)
        val usuario = intent.getStringExtra("usuario") ?: "Usuario"
        textoBienvenida.text = "Hola, $usuario"
    }
}