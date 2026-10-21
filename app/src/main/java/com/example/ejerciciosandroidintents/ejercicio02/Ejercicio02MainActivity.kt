package com.example.ejerciciosandroidintents.ejercicio02

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio02MainActivity : AppCompatActivity() {

    private lateinit var textoResultado: TextView

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val mensajeDevuelto = result.data?.getStringExtra("mensaje_devuelto") ?: "Sin datos"
            textoResultado.text = mensajeDevuelto
        } else {
            textoResultado.text = "Acción cancelada"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio02_main)

        textoResultado = findViewById(R.id.textoResultadoEj2)
        val botonAbrir = findViewById<Button>(R.id.botonAbrirEj2)

        botonAbrir.setOnClickListener {
            val intent = Intent(this, Ejercicio02SegundaActivity::class.java)
            launcher.launch(intent)
        }
    }
}