package com.example.ejerciciosandroidintents.ejercicio11

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ejerciciosandroidintents.R

class Ejercicio11MainActivity : AppCompatActivity() {

    private var notaTexto = "Comprar víveres para la semana."
    private var contadorEdiciones = 0
    private lateinit var textoNota: TextView
    private lateinit var textoContador: TextView

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            notaTexto = result.data?.getStringExtra("nueva_nota") ?: notaTexto
            contadorEdiciones = result.data?.getIntExtra("nuevo_contador", contadorEdiciones) ?: contadorEdiciones
            actualizarUI()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio11_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarEj11)
        setSupportActionBar(toolbar)

        textoNota = findViewById(R.id.textoNotaEj11)
        textoContador = findViewById(R.id.textoContadorEj11)

        actualizarUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicio11, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_editar_nota_ej11) {
            val intent = Intent(this, Ejercicio11EditarNotaActivity::class.java).apply {
                putExtra("nota_actual", notaTexto)
                putExtra("contador_actual", contadorEdiciones)
            }
            launcher.launch(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun actualizarUI() {
        textoContador.text = "Ediciones realizadas: $contadorEdiciones"
        textoNota.text = notaTexto
    }
}