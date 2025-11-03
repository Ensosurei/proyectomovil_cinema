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

class Pregunta5Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pregunta5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGuardar = findViewById<Button>(R.id.btnGuardar)
        val btnRegresar = findViewById<Button>(R.id.btnRegresar)

        val radioOPC1 = findViewById<RadioButton>(R.id.RadioOpc1)
        val radioOPC2 = findViewById<RadioButton>(R.id.RadioOpc2)
        val radioOPC3 = findViewById<RadioButton>(R.id.RadioOpc3)

        val pregunta1 = intent.getStringExtra("pregunta1")
        val pregunta2 = intent.getStringExtra("pregunta2")
        val pregunta3 = intent.getStringExtra("pregunta3")
        val pregunta4 = intent.getStringExtra("pregunta4")


        btnGuardar.setOnClickListener {
            if (!(radioOPC1.isChecked || radioOPC2.isChecked || radioOPC3.isChecked)) {
                Toast.makeText(this, "Debes seleccionar una opción", Toast.LENGTH_SHORT).show()
            }else{
                val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
                val db = admin.writableDatabase

                val registro = ContentValues()

                registro.put("pregunta1", pregunta1)
                registro.put("pregunta2", pregunta2)
                registro.put("pregunta3", pregunta3)
                registro.put("pregunta4", pregunta4)

                val intent = Intent(this, MainActivity::class.java)
                if(radioOPC1.isChecked)
                    registro.put("pregunta5","3D")
                else if(radioOPC2.isChecked)
                    registro.put("pregunta5","Sala normal")
                else if(radioOPC3.isChecked)
                    registro.put("pregunta5","Macro XE")
                db.insert("encuesta", null, registro)
                db.close()
                Toast.makeText(this, "Encuesta guardada", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }
}