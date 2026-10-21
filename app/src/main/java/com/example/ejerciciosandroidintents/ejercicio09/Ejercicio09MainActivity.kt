package com.example.ejerciciosandroidintents.ejercicio09

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

class Ejercicio09MainActivity : AppCompatActivity() {

    private var mensaje = "Este es el mensaje por defecto"
    private lateinit var textoMensaje: TextView

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            mensaje = result.data?.getStringExtra("nuevo_mensaje") ?: mensaje
            textoMensaje.text = mensaje
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio09_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarEj9)
        setSupportActionBar(toolbar)

        textoMensaje = findViewById(R.id.textoMensajeEj9)
        textoMensaje.text = mensaje
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicio09, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_config_ej9) {
            val intent = Intent(this, Ejercicio09ConfigActivity::class.java).apply {
                putExtra("mensaje_actual", mensaje)
            }
            launcher.launch(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}