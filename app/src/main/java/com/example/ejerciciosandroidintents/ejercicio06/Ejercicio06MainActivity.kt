package com.example.ejerciciosandroidintents.ejercicio06

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio06MainActivity : AppCompatActivity() {

    private var numero = 10
    private lateinit var textoNumero: TextView

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            numero = result.data?.getIntExtra("resultado_final", numero) ?: numero
            textoNumero.text = numero.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio06_main)

        textoNumero = findViewById(R.id.textoNumeroEj6)
        val botonEditar = findViewById<Button>(R.id.botonEditarEj6)

        textoNumero.text = numero.toString()

        botonEditar.setOnClickListener {
            val intent = Intent(this, Ejercicio06PrimeraActivity::class.java).apply {
                putExtra("numero_inicial", numero)
            }
            launcher.launch(intent)
        }
    }
}