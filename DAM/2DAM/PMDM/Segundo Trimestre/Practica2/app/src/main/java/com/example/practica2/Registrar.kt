package com.example.practica2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText



const val EXTRA_NOMBRE = "com.example.myfirstapp.NOMBRE"
const val EXTRA_APELLIDO = "com.example.myfirstapp.APELLIDO"

class Registrar : AppCompatActivity() {

    lateinit var nombre: EditText
    lateinit var apellido: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_registrar)

        nombre = findViewById<EditText>(R.id.editTextNombre)
        apellido = findViewById<EditText>(R.id.editTextApellido)

    }


    fun btEnviar(view: View){
        val data = Intent()

        data.putExtra(EXTRA_NOMBRE, nombre.text.toString() )
        data.putExtra(EXTRA_APELLIDO, apellido.text.toString() )

        setResult(RESULT_OK, data)
        finish()
    }
}