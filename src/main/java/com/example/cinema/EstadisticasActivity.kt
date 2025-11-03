package com.example.cinema

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EstadisticasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estadisticas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnRegresar = findViewById<Button>(R.id.btnRegresar)
        val txtTotalEncuestas = findViewById<TextView>(R.id.txt_total_encuestas)

        val txtR1O1 = findViewById<TextView>(R.id.txtR1O1)
        val txtR1O2 = findViewById<TextView>(R.id.txtR1O2)
        val txtR1O3 = findViewById<TextView>(R.id.txtR1O3)
        val txtR1O4 = findViewById<TextView>(R.id.txtR1O4)

        val txtR2O1 = findViewById<TextView>(R.id.txtR2O1)
        val txtR2O2 = findViewById<TextView>(R.id.txtR2O2)
        val txtR2O3 = findViewById<TextView>(R.id.txtR2O3)
        val txtR2O4 = findViewById<TextView>(R.id.txtR2O4)

        val txtR3O1 = findViewById<TextView>(R.id.txtR3O1)
        val txtR3O2 = findViewById<TextView>(R.id.txtR3O2)
        val txtR3O3 = findViewById<TextView>(R.id.txtR3O3)
        val txtR3O4 = findViewById<TextView>(R.id.txtR3O4)

        val txtR4O1 = findViewById<TextView>(R.id.txtR4O1)
        val txtR4O2 = findViewById<TextView>(R.id.txtR4O2)
        val txtR4O3 = findViewById<TextView>(R.id.txtR4O3)
        val txtR4O4 = findViewById<TextView>(R.id.txtR4O4)

        val txtR5O1 = findViewById<TextView>(R.id.txtR5O1)
        val txtR5O2 = findViewById<TextView>(R.id.txtR5O2)
        val txtR5O3 = findViewById<TextView>(R.id.txtR5O3)


        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.readableDatabase

        val resultados = db.rawQuery("SELECT * FROM encuesta", null)
        txtTotalEncuestas.text = "Total de Encuestas Realizadas: ${resultados.count.toString()}"
        resultados.close()

        fun contarVotos(columna: String, respuesta: String): Int {
            val consulta = "SELECT COUNT(*) FROM encuesta WHERE $columna = ?"
            val cursor = db.rawQuery(consulta, arrayOf(respuesta))
            var cantidad = 0
            if (cursor.moveToFirst()) {
                cantidad = cursor.getInt(0)
            }
            cursor.close()
            return cantidad
        }

        txtR1O1.text = "1 vez al mes: ${contarVotos("pregunta1", "1 vez al mes")} votos"
        txtR1O2.text = "1 vez cada semana: ${contarVotos("pregunta1", "1 vez cada semana")} votos"
        txtR1O3.text = "Mas de una vez a la semana: ${contarVotos("pregunta1", "Mas de una vez a la semana")} votos"
        txtR1O4.text = "Casi nunca: ${contarVotos("pregunta1", "Casi nunca")} votos"

        txtR2O1.text = "Malo: ${contarVotos("pregunta2", "Malo")} votos"
        txtR2O2.text = "Regular: ${contarVotos("pregunta2", "Regular")} votos"
        txtR2O3.text = "Bueno: ${contarVotos("pregunta2", "Bueno")} votos"
        txtR2O4.text = "Excelente: ${contarVotos("pregunta2", "Excelente")} votos"

        txtR3O1.text = "Malo: ${contarVotos("pregunta3", "Malo")} votos"
        txtR3O2.text = "Regular: ${contarVotos("pregunta3", "Regular")} votos"
        txtR3O3.text = "Bueno: ${contarVotos("pregunta3", "Bueno")} votos"
        txtR3O4.text = "Excelente: ${contarVotos("pregunta3", "Excelente")} votos"

        txtR4O1.text = "Malo: ${contarVotos("pregunta4", "Malo")} votos"
        txtR4O2.text = "Regular: ${contarVotos("pregunta4", "Regular")} votos"
        txtR4O3.text = "Bueno: ${contarVotos("pregunta4", "Bueno")} votos"
        txtR4O4.text = "Excelente: ${contarVotos("pregunta4", "Excelente")} votos"

        txtR5O1.text = "3D: ${contarVotos("pregunta5", "3D")} votos"
        txtR5O2.text = "Sala Normal: ${contarVotos("pregunta5", "Sala normal")} votos"
        txtR5O3.text = "Macro XE: ${contarVotos("pregunta5", "Macro XE")} votos"

        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}