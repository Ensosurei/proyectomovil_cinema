package com.example.cinema

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pregunta1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pregunta1)
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

        btnSiguiente.setOnClickListener {
            if (!(radioOPC1.isChecked || radioOPC2.isChecked || radioOPC3.isChecked || radioOPC4.isChecked)) {
                Toast.makeText(this, "Debes seleccionar una opción", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, Pregunta2Activity::class.java)
                if(radioOPC1.isChecked)
                    intent.putExtra("pregunta1","1 vez al mes")
                else if(radioOPC2.isChecked)
                    intent.putExtra("pregunta1","1 vez cada semana")
                else if(radioOPC3.isChecked)
                    intent.putExtra("pregunta1","Mas de una vez a la semana")
                else if(radioOPC4.isChecked)
                    intent.putExtra("pregunta1","Casi nunca")
                startActivity(intent)
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }

    }
}