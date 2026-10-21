package com.example.ejerciciosandroidintents.ejercicio13

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

class Ejercicio13MainActivity : AppCompatActivity() {

    private val nombreOriginal = "Laptop Gaming"
    private val precioOriginal = "$1200"
    private val descripcionOriginal = "Procesador i7, 16GB RAM, RTX 4060"

    private var nombre = nombreOriginal
    private var precio = precioOriginal
    private var descripcion = descripcionOriginal

    private lateinit var textoProducto: TextView

    private val launcherNombre = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            nombre = result.data?.getStringExtra("nuevo_nombre") ?: nombre
            actualizarUI()
        }
    }

    private val launcherPrecio = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            precio = result.data?.getStringExtra("nuevo_precio") ?: precio
            actualizarUI()
        }
    }

    private val launcherDescripcion = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            descripcion = result.data?.getStringExtra("nueva_descripcion") ?: descripcion
            actualizarUI()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio13_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarEj13)
        setSupportActionBar(toolbar)

        textoProducto = findViewById(R.id.textoProductoEj13)
        actualizarUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicio13, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_editar_nombre_ej13 -> {
                val intent = Intent(this, Ejercicio13EditarNombreActivity::class.java).apply {
                    putExtra("nombre_actual", nombre)
                }
                launcherNombre.launch(intent)
                return true
            }
            R.id.action_editar_precio_ej13 -> {
                val intent = Intent(this, Ejercicio13EditarPrecioActivity::class.java).apply {
                    putExtra("precio_actual", precio)
                }
                launcherPrecio.launch(intent)
                return true
            }
            R.id.action_editar_descripcion_ej13 -> {
                val intent = Intent(this, Ejercicio13EditarDescripcionActivity::class.java).apply {
                    putExtra("descripcion_actual", descripcion)
                }
                launcherDescripcion.launch(intent)
                return true
            }
            R.id.action_restablecer_ej13 -> {
                nombre = nombreOriginal
                precio = precioOriginal
                descripcion = descripcionOriginal
                actualizarUI()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun actualizarUI() {
        textoProducto.text = "Producto: $nombre\nPrecio: $precio\nDescripción: $descripcion"
    }
}