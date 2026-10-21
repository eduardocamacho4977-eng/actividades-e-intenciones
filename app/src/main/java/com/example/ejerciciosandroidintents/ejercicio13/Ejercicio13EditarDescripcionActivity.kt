package com.example.ejerciciosandroidintents.ejercicio13

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio13EditarDescripcionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio13_editar_descripcion)

        val campoDescripcion = findViewById<EditText>(R.id.campoDescripcionEj13)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarDescripcionEj13)

        val descripcionActual = intent.getStringExtra("descripcion_actual") ?: ""
        campoDescripcion.setText(descripcionActual)

        botonGuardar.setOnClickListener {
            val nuevaDescripcion = campoDescripcion.text.toString()
            val resultIntent = Intent().apply {
                putExtra("nueva_descripcion", nuevaDescripcion)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}