package com.example.ejerciciosandroidintents.ejercicio07

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

class Ejercicio07MainActivity : AppCompatActivity() {

    private var nombre = "Carlos Ruiz"
    private var correo = "carlos@example.com"
    private var edad = 32
    private lateinit var textoPerfil: TextView

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            nombre = result.data?.getStringExtra("nombre") ?: nombre
            correo = result.data?.getStringExtra("correo") ?: correo
            edad = result.data?.getIntExtra("edad", edad) ?: edad
            actualizarUI()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio07_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarEj7)
        setSupportActionBar(toolbar)

        textoPerfil = findViewById(R.id.textoPerfilEj7)
        actualizarUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicio07, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_editar_ej7) {
            val intent = Intent(this, Ejercicio07EditarPerfilActivity::class.java).apply {
                putExtra("nombre", nombre)
                putExtra("correo", correo)
                putExtra("edad", edad)
            }
            launcher.launch(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun actualizarUI() {
        textoPerfil.text = "Nombre: $nombre\nCorreo: $correo\nEdad: $edad años"
    }
}