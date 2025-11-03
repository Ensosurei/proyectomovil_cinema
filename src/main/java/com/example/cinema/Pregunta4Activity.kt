package com.example.cinema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pregunta4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pregunta4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        val radioOPC1 = findViewById<RadioButton>(R.id.RadioOpc1)
        val radioOPC2 = findViewById<RadioButton>(R.id.RadioOpc2)
        val radioOPC3 = findViewById<RadioButton>(R.id.RadioOpc3)
        val radioOPC4 = findViewById<RadioButton>(R.id.RadioOpc4)

        val pregunta1 = intent.getStringExtra("pregunta1")
        val pregunta2 = intent.getStringExtra("pregunta2")
        val pregunta3 = intent.getStringExtra("pregunta3")

        btnSiguiente.setOnClickListener {
            if (!(radioOPC1.isChecked || radioOPC2.isChecked || radioOPC3.isChecked || radioOPC4.isChecked)) {
                Toast.makeText(this, "Debes seleccionar una opción", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, Pregunta5Activity::class.java)
                intent.putExtra("pregunta1",pregunta1)
                intent.putExtra("pregunta2",pregunta2)
                intent.putExtra("pregunta3",pregunta3)
                if(radioOPC1.isChecked)
                    intent.putExtra("pregunta4","Malo")
                else if(radioOPC2.isChecked)
                    intent.putExtra("pregunta4","Regular")
                else if(radioOPC3.isChecked)
                    intent.putExtra("pregunta4","Bueno")
                else if(radioOPC4.isChecked)
                    intent.putExtra("pregunta4","Excelente")
                startActivity(intent)
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}