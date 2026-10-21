package com.example.ejerciciosandroidintents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejerciciosandroidintents.ejercicio01.Ejercicio01MainActivity
import com.example.ejerciciosandroidintents.ejercicio02.Ejercicio02MainActivity
import com.example.ejerciciosandroidintents.ejercicio03.Ejercicio03MainActivity
import com.example.ejerciciosandroidintents.ejercicio04.Ejercicio04MainActivity
import com.example.ejerciciosandroidintents.ejercicio05.Ejercicio05LoginActivity
import com.example.ejerciciosandroidintents.ejercicio06.Ejercicio06MainActivity
import com.example.ejerciciosandroidintents.ejercicio07.Ejercicio07MainActivity
import com.example.ejerciciosandroidintents.ejercicio08.Ejercicio08MainActivity
import com.example.ejerciciosandroidintents.ejercicio09.Ejercicio09MainActivity
import com.example.ejerciciosandroidintents.ejercicio10.Ejercicio10MainActivity
import com.example.ejerciciosandroidintents.ejercicio11.Ejercicio11MainActivity
import com.example.ejerciciosandroidintents.ejercicio12.Ejercicio12MainActivity
import com.example.ejerciciosandroidintents.ejercicio13.Ejercicio13MainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- NAVEGACIÓN A CADA UNO DE LOS 13 EJERCICIOS ---
        findViewById<Button>(R.id.btnEj1).setOnClickListener {
            startActivity(Intent(this, Ejercicio01MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj2).setOnClickListener {
            startActivity(Intent(this, Ejercicio02MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj3).setOnClickListener {
            startActivity(Intent(this, Ejercicio03MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj4).setOnClickListener {
            startActivity(Intent(this, Ejercicio04MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj5).setOnClickListener {
            startActivity(Intent(this, Ejercicio05LoginActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj6).setOnClickListener {
            startActivity(Intent(this, Ejercicio06MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj7).setOnClickListener {
            startActivity(Intent(this, Ejercicio07MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj8).setOnClickListener {
            startActivity(Intent(this, Ejercicio08MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj9).setOnClickListener {
            startActivity(Intent(this, Ejercicio09MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj10).setOnClickListener {
            startActivity(Intent(this, Ejercicio10MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj11).setOnClickListener {
            startActivity(Intent(this, Ejercicio11MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj12).setOnClickListener {
            startActivity(Intent(this, Ejercicio12MainActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj13).setOnClickListener {
            startActivity(Intent(this, Ejercicio13MainActivity::class.java))
        }
    }
}