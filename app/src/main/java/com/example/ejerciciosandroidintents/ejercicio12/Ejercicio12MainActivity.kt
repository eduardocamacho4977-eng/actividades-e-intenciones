package com.example.ejerciciosandroidintents.ejercicio12

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ejerciciosandroidintents.R

class Ejercicio12MainActivity : AppCompatActivity() {

    private var mensaje = "Texto Configurable"
    private var tamanoSeleccionado = "Mediano" // Pequeño, Mediano, Grande
    private lateinit var textoMensaje: TextView

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            mensaje = result.data?.getStringExtra("mensaje") ?: mensaje
            tamanoSeleccionado = result.data?.getStringExtra("tamano") ?: tamanoSeleccionado
            actualizarUI()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio12_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarEj12)
        setSupportActionBar(toolbar)

        textoMensaje = findViewById(R.id.textoMensajeEj12)
        actualizarUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicio12, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_config_ej12) {
            val intent = Intent(this, Ejercicio12ConfigActivity::class.java).apply {
                putExtra("mensaje_actual", mensaje)
                putExtra("tamano_actual", tamanoSeleccionado)
            }
            launcher.launch(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun actualizarUI() {
        textoMensaje.text = mensaje
        when (tamanoSeleccionado) {
            "Pequeño" -> textoMensaje.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
            "Grande" -> textoMensaje.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28f)
            else -> textoMensaje.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        }
    }
}