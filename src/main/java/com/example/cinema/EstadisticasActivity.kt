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

        val txtRespuestaR1 = findViewById<TextView>(R.id.txtRespuestaR1)
        val txtRespuestaR2 = findViewById<TextView>(R.id.txtRespuestaR2)
        val txtRespuestaR3 = findViewById<TextView>(R.id.txtRespuestaR3)
        val txtRespuestaR4 = findViewById<TextView>(R.id.txtRespuestaR4)
        val txtRespuestaR5 = findViewById<TextView>(R.id.txtRespuestaR5)

        val txtRespuestaC1 = findViewById<TextView>(R.id.txtRespuestaC1)
        val txtRespuestaC2 = findViewById<TextView>(R.id.txtRespuestaC2)
        val txtRespuestaC3 = findViewById<TextView>(R.id.txtRespuestaC3)
        val txtRespuestaC4 = findViewById<TextView>(R.id.txtRespuestaC4)
        val txtRespuestaC5 = findViewById<TextView>(R.id.txtRespuestaC5)

        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val db = admin.writableDatabase

        val resultados = db.rawQuery("SELECT * FROM encuesta", null)
        txtTotalEncuestas.text = "Total de Encuestas Realizadas: ${resultados.count.toString()}"
        resultados.close()

        val consultaPregunta1 = """SELECT pregunta1, COUNT(pregunta1) as total FROM encuesta 
            WHERE pregunta1 IS NOT NULL AND pregunta1 != '' GROUP BY pregunta1 ORDER BY total DESC LIMIT 1"""
        val contenidoP1 = db.rawQuery(consultaPregunta1, null)
        if (contenidoP1.moveToFirst()) {
            txtRespuestaR1.text = "Respuesta recurrente: ${contenidoP1.getString(0)}"
            txtRespuestaC1.text = "Cantidad de veces elegida: ${contenidoP1.getInt(1)}"
        }else{
            txtRespuestaR1.text = "Respuesta recurrente: No hay respuestas"
            txtRespuestaC1.text = "Cantidad de veces elegida: 0"
        }
        contenidoP1.close()

        val consultaPregunta2 = """SELECT pregunta2, COUNT(pregunta2) as total FROM encuesta 
            WHERE pregunta2 IS NOT NULL AND pregunta2 != '' GROUP BY pregunta2 ORDER BY total DESC LIMIT 1"""

        val contenidoP2 = db.rawQuery(consultaPregunta2, null)
        if (contenidoP2.moveToFirst()) {
            txtRespuestaR2.text = "Respuesta recurrente: ${contenidoP2.getString(0)}"
            txtRespuestaC2.text = "Cantidad de veces elegida: ${contenidoP2.getInt(1)}"
        }else{
            txtRespuestaR2.text = "Respuesta recurrente: No hay respuestas"
            txtRespuestaC2.text = "Cantidad de veces elegida: 0"
        }
        contenidoP2.close()

        val consultaPregunta3 = """SELECT pregunta3, COUNT(pregunta3) as total FROM encuesta 
            WHERE pregunta3 IS NOT NULL AND pregunta3 != '' GROUP BY pregunta3 ORDER BY total DESC LIMIT 1"""
        val contenidoP3 = db.rawQuery(consultaPregunta3, null)
        if (contenidoP3.moveToFirst()) {
            txtRespuestaR3.text = "Respuesta recurrente: ${contenidoP3.getString(0)}"
            txtRespuestaC3.text = "Cantidad de veces elegida: ${contenidoP3.getInt(1)}"
        }else{
            txtRespuestaR3.text = "Respuesta recurrente: No hay respuestas"
            txtRespuestaC3.text = "Cantidad de veces elegida: 0"
        }
        contenidoP3.close()

        val consultaPregunta4 = """SELECT pregunta4, COUNT(pregunta4) as total FROM encuesta 
            WHERE pregunta4 IS NOT NULL AND pregunta4 != '' GROUP BY pregunta4 ORDER BY total DESC LIMIT 1"""
        val contenidoP4 = db.rawQuery(consultaPregunta4, null)
        if (contenidoP4.moveToFirst()) {
            txtRespuestaR4.text = "Respuesta recurrente: ${contenidoP4.getString(0)}"
            txtRespuestaC4.text = "Cantidad de veces elegida: ${contenidoP4.getInt(1)}"
        }else{
            txtRespuestaR4.text = "Respuesta recurrente: No hay respuestas"
            txtRespuestaC4.text = "Cantidad de veces elegida: 0"
        }
        contenidoP4.close()

        val consultaPregunta5 = """SELECT pregunta5, COUNT(pregunta5) as total FROM encuesta 
            WHERE pregunta5 IS NOT NULL AND pregunta5 != '' GROUP BY pregunta5 ORDER BY total DESC LIMIT 1"""
        val contenidoP5 = db.rawQuery(consultaPregunta5, null)
        if (contenidoP5.moveToFirst()) {
            txtRespuestaR5.text = "Respuesta recurrente: ${contenidoP5.getString(0)}"
            txtRespuestaC5.text = "Cantidad de veces elegida: ${contenidoP5.getInt(1)}"
        }else{
            txtRespuestaR5.text = "Respuesta recurrente: No hay respuestas"
            txtRespuestaC5.text = "Cantidad de veces elegida: 0"
        }
        contenidoP5.close()
        db.close()

        btnRegresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}