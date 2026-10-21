package com.example.ejerciciosandroidintents.ejercicio13

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio13EditarPrecioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio13_editar_precio)

        val campoPrecio = findViewById<EditText>(R.id.campoPrecioEj13)
        val botonGuardar = findViewById<Button>(R.id.botonGuardarPrecioEj13)

        val precioActual = intent.getStringExtra("precio_actual") ?: ""
        campoPrecio.setText(precioActual)

        botonGuardar.setOnClickListener {
            val nuevoPrecio = campoPrecio.text.toString()
            val resultIntent = Intent().apply {
                putExtra("nuevo_precio", nuevoPrecio)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}