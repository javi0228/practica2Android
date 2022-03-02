package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val nombre = intent.getStringExtra(EXTRA_NOMBRE)
        val apellido = intent.getStringExtra(EXTRA_APELLIDO)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = nombre

        }

        val apellidoView = findViewById<TextView>(R.id.textView2).apply {
            text = apellido

        }

    }
}