package com.example.ejerciciosandroidintents.ejercicio10

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio10EditarTituloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio10_editar_titulo)

        val campoTitulo = findViewById<EditText>(R.id.campoTituloEj10)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarTituloEj10)

        val tituloActual = intent.getStringExtra("titulo_actual") ?: ""
        campoTitulo.setText(tituloActual)

        botonGuardar.setOnClickListener {
            val nuevoTitulo = campoTitulo.text.toString()
            val resultIntent = Intent().apply {
                putExtra("nuevo_titulo", nuevoTitulo)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}