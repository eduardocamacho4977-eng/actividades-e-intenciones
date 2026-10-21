package com.example.ejerciciosandroidintents.ejercicio08

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

class Ejercicio08MainActivity : AppCompatActivity() {

    private var nombreContacto = "María López"
    private var telefonoContacto = "+57 300 123 4567"
    private lateinit var textoContacto: TextView

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            nombreContacto = result.data?.getStringExtra("nombre") ?: nombreContacto
            telefonoContacto = result.data?.getStringExtra("telefono") ?: telefonoContacto
            actualizarUI()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio08_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarEj8)
        setSupportActionBar(toolbar)

        textoContacto = findViewById(R.id.textoContactoEj8)
        actualizarUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicio08, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_editar_contacto_ej8) {
            val intent = Intent(this, Ejercicio08EditarContactoActivity::class.java).apply {
                putExtra("nombre", nombreContacto)
                putExtra("telefono", telefonoContacto)
            }
            launcher.launch(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun actualizarUI() {
        textoContacto.text = "Contacto:\n$nombreContacto\nTel: $telefonoContacto"
    }
}