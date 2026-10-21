package com.example.ejerciciosandroidintents.ejercicio10

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio10EditarAutorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio10_editar_autor)

        val campoAutor = findViewById<EditText>(R.id.campoAutorEj10)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarAutorEj10)

        val autorActual = intent.getStringExtra("autor_actual") ?: ""
        campoAutor.setText(autorActual)

        botonGuardar.setOnClickListener {
            val nuevoAutor = campoAutor.text.toString()
            val resultIntent = Intent().apply {
                putExtra("nuevo_autor", nuevoAutor)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}