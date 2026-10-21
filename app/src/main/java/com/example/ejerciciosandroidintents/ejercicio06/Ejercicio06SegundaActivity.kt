package com.example.ejerciciosandroidintents.ejercicio06

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio06SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio06_segunda)

        val resultadoSuma = intent.getIntExtra("resultado_suma", 0)

        val textoSuma = findViewById<TextView>(R.id.textoValorSumaEj6)
        val campoFactor = findViewById<EditText>(R.id.campoMultiplicarEj6)
        val botonFinalizar = findViewById<Button>(R.id.botonFinalizarEj6)

        textoSuma.text = "Valor tras sumar: $resultadoSuma"

        botonFinalizar.setOnClickListener {
            val factor = campoFactor.text.toString().toIntOrNull() ?: 1
            val resultadoFinal = resultadoSuma * factor

            val resultIntent = Intent().apply {
                putExtra("resultado_final", resultadoFinal)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}