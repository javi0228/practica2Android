package com.example.prueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_NOMBRE = "com.example.myfirstapp.NOMBRE"
const val EXTRA_APELLIDO = "com.example.myfirstapp.APELLIDO"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {

        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val nombre = editText.text.toString()

        val editApellido = findViewById<EditText>(R.id.editTextTextPersonName2)
        val apellido = editApellido.text.toString()

        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_NOMBRE, nombre)
            putExtra(EXTRA_APELLIDO,apellido)
        }
        startActivity(intent)
    }
}