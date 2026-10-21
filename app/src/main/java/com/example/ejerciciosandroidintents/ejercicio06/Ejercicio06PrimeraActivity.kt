package com.example.ejerciciosandroidintents.ejercicio06

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio06PrimeraActivity : AppCompatActivity() {

    private var numeroInicial = 0

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            setResult(Activity.RESULT_OK, result.data)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio06_primera)

        numeroInicial = intent.getIntExtra("numero_inicial", 10)

        val textoBase = findViewById<TextView>(R.id.textoValorBaseEj6)
        val campoSuma = findViewById<EditText>(R.id.campoSumaEj6)
        val botonSiguiente = findViewById<Button>(R.id.botonSiguienteEj6)

        textoBase.text = "Valor inicial: $numeroInicial"

        botonSiguiente.setOnClickListener {
            val suma = campoSuma.text.toString().toIntOrNull() ?: 0
            val resultadoSuma = numeroInicial + suma

            val intent = Intent(this, Ejercicio06SegundaActivity::class.java).apply {
                putExtra("resultado_suma", resultadoSuma)
            }
            launcher.launch(intent)
        }
    }
}