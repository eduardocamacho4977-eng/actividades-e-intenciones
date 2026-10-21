package com.example.ejerciciosandroidintents.ejercicio05

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciosandroidintents.R

class Ejercicio05LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio05_login)

        val campoUsuario = findViewById<EditText>(R.id.campoUsuarioEj5)
        val campoPassword = findViewById<EditText>(R.id.campoPasswordEj5)
        val botonIngresar = findViewById<Button>(R.id.botonIngresarEj5)

        botonIngresar.setOnClickListener {
            val usuario = campoUsuario.text.toString().trim()
            val password = campoPassword.text.toString().trim()

            if (usuario.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, Ejercicio05BienvenidaActivity::class.java).apply {
                    putExtra("usuario", usuario)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Datos de usuario o contraseña inválidos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}