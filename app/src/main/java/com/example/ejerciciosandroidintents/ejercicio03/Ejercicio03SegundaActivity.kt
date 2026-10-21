package com.example.ejerciciosandroidintents.ejercicio03

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio03SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio03_segunda)

        val textoDatos = findViewById<TextView>(R.id.textoDatosPersonaEj3)

        val persona: Persona? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("persona", Persona::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("persona") as? Persona
        }

        if (persona != null) {
            textoDatos.text = "Nombre: ${persona.nombre}\nEdad: ${persona.edad} años"
        } else {
            textoDatos.text = "No se recibieron datos de Persona"
        }
    }
}