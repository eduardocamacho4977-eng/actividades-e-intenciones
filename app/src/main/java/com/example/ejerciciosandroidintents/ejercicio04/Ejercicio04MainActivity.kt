package com.example.ejerciciosandroidintents.ejercicio04

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio04MainActivity : AppCompatActivity() {

    private var nombre = "Ana Martínez"
    private var edad = 29
    private lateinit var textoPerfil: TextView

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            nombre = result.data?.getStringExtra("nombre") ?: nombre
            edad = result.data?.getIntExtra("edad", edad) ?: edad
            actualizarUI()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio04_main)

        textoPerfil = findViewById(R.id.textoPerfilEj4)
        val botonEditar = findViewById<Button>(R.id.botonEditarEj4)

        actualizarUI()

        botonEditar.setOnClickListener {
            val intent = Intent(this, Ejercicio04EdicionActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("edad", edad)
            }
            launcher.launch(intent)
        }
    }

    private fun actualizarUI() {
        textoPerfil.text = "Nombre: $nombre\nEdad: $edad años"
    }
}