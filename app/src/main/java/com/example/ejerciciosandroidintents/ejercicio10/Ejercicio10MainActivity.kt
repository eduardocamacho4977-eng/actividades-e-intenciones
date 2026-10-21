package com.example.ejerciciosandroidintents.ejercicio10

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

class Ejercicio10MainActivity : AppCompatActivity() {

    private var titulo = "Cien Años de Soledad"
    private var autor = "Gabriel García Márquez"
    private lateinit var textoLibro: TextView

    private val launcherTitulo = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            titulo = result.data?.getStringExtra("nuevo_titulo") ?: titulo
            actualizarUI()
        }
    }

    private val launcherAutor = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            autor = result.data?.getStringExtra("nuevo_autor") ?: autor
            actualizarUI()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio10_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbarEj10)
        setSupportActionBar(toolbar)

        textoLibro = findViewById(R.id.textoLibroEj10)
        actualizarUI()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_ejercicio10, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_editar_titulo_ej10 -> {
                val intent = Intent(this, Ejercicio10EditarTituloActivity::class.java).apply {
                    putExtra("titulo_actual", titulo)
                }
                launcherTitulo.launch(intent)
                return true
            }
            R.id.action_editar_autor_ej10 -> {
                val intent = Intent(this, Ejercicio10EditarAutorActivity::class.java).apply {
                    putExtra("autor_actual", autor)
                }
                launcherAutor.launch(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun actualizarUI() {
        textoLibro.text = "Título: $titulo\nAutor: $autor"
    }
}