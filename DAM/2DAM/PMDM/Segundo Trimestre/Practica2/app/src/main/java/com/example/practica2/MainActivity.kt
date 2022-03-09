package com.example.practica2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var valoracion:Float? = 0.0f
    private var nombre: String?=null
    private var apellido: String?=null
    private var darkMode:Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("mensaje","Pasando por onCreate desde el main")
        setContentView(R.layout.activity_main)


        val btRate = this.findViewById<Button>(R.id.Valorar)

        btRate.setOnClickListener {
            val intent = Intent(this, Valorar::class.java)
            startActivityForResult(intent, 11)
        }

        val btRegistro =this.findViewById<Button>(R.id.Identificar)

        btRegistro.setOnClickListener {
            val intent = Intent (this,Registrar::class.java)
            startActivityForResult(intent,12)
        }

        val btCambiarFondo =this.findViewById<Button>(R.id.CambiarFondo)

        btCambiarFondo.setOnClickListener {
            val intent = Intent(this, CambiarFondo::class.java)
            startActivityForResult(intent, 13)
        }

        val btDestruir =this.findViewById<Button>(R.id.Destruir)

        btDestruir.setOnClickListener {
            finish()
        }

        val btResultados =this.findViewById<Button>(R.id.mostrarResultados)

        btResultados.setOnClickListener {
            val intent = Intent(this, MostrarResultados::class.java).apply {
                putExtra(EXTRA_NOMBRE, nombre)
                putExtra(EXTRA_APELLIDO,apellido)
                putExtra(EXTRA_DARK_MODE,darkMode)
                putExtra(EXTRA_VALORACION,valoracion)
            }
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode== RESULT_OK && requestCode==11){
            valoracion = data?.getFloatExtra(EXTRA_VALORACION,0.0f)

        }else if(resultCode== RESULT_OK && requestCode==12){
            nombre=data?.getStringExtra(EXTRA_NOMBRE)
            apellido=data?.getStringExtra(EXTRA_APELLIDO)

        }else if(resultCode== RESULT_OK && requestCode==13) {
            darkMode = data?.getBooleanExtra(EXTRA_DARK_MODE, false)
            if(darkMode==true) {
                var fondo = findViewById<ConstraintLayout>(R.id.Background)
                var fondoMenu = findViewById<LinearLayout>(R.id.BackgroundMenu)



                val vistas: ArrayList<View> = fondoMenu.getTouchables()
                val it: Iterator<View> = vistas.iterator()
                while (it.hasNext()) {
                    val v: View = it.next()
                    if (v is Button) v.setTextColor(Color.WHITE)
                }

                fondoMenu.setBackgroundColor(Color.DKGRAY)

                fondo.setBackgroundColor(Color.BLACK)

            }

        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("mensaje","Pasando por onPause desde el main")
    }

    override fun onRestart() {
        super.onRestart()

        Log.d("mensaje","Pasando por onRestart desde el main")
    }

    override fun onResume() {
        super.onResume()

        Log.d("mensaje","Pasando por onResume desde el main")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("mensaje","Pasando por onDestroy desde el main")
    }


}