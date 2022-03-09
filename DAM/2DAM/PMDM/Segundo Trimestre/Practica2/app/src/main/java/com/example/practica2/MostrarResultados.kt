package com.example.practica2

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import android.widget.TextView

class MostrarResultados : AppCompatActivity() {

    private var valoracion:Float? = 0.0f
    private var nombre: String?=null
    private var apellido: String?=null
    private var darkMode:Boolean? = false


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("mensaje","Pasando por onCreate desde el mostrarResultados")

        setContentView(R.layout.activity_mostrar_resultados)

        valoracion=intent.getFloatExtra(EXTRA_VALORACION,0.0f)
        nombre = intent.getStringExtra(EXTRA_NOMBRE)
        apellido = intent.getStringExtra(EXTRA_APELLIDO)
        darkMode = intent.getBooleanExtra(EXTRA_DARK_MODE,false)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBarMostrar)

        ratingBar.rating= valoracion as Float

        findViewById<EditText>(R.id.editTextNombre2).apply {
            setText(nombre)
            setBackgroundColor(Color.LTGRAY)
            setTextColor(Color.WHITE)
        }

        findViewById<EditText>(R.id.editTextApellido2).apply {
            setText(apellido)
            setBackgroundColor(Color.LTGRAY)
            setTextColor(Color.WHITE)
        }


        if(darkMode==true) {

            findViewById<EditText>(R.id.editTextNombre2).apply {

                setBackgroundColor(Color.LTGRAY)
                setTextColor(Color.WHITE)
            }

            findViewById<EditText>(R.id.editTextApellido2).apply {

                setBackgroundColor(Color.LTGRAY)
                setTextColor(Color.WHITE)
            }

            var fondo = findViewById<ConstraintLayout>(R.id.Background)

            fondo.setBackgroundColor(Color.BLACK)

            findViewById<TextView>(R.id.textNombre).setTextColor(Color.WHITE)
            findViewById<TextView>(R.id.textApellido).setTextColor(Color.WHITE)




        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("mensaje","Pasando por onPause desde el mostrarResultados")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("mensaje","Pasando por onRestart desde el mostrarResultados")
    }

    override fun onResume() {
        super.onResume()
        Log.d("mensaje","Pasando por onResume desde el mostrarResultados")
    }
}