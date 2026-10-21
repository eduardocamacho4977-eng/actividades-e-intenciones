package com.example.ejerciciosandroidintents.ejercicio11

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio11EditarNotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio11_editar)

        val campoNota = findViewById<EditText>(R.id.campoNotaEj11)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarNotaEj11)

        val notaActual = intent.getStringExtra("nota_actual") ?: ""
        val contadorActual = intent.getIntExtra("contador_actual", 0)

        campoNota.setText(notaActual)

        botonGuardar.setOnClickListener {
            val nuevaNota = campoNota.text.toString()
            val nuevoContador = contadorActual + 1

            val resultIntent = Intent().apply {
                putExtra("nueva_nota", nuevaNota)
                putExtra("nuevo_contador", nuevoContador)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}