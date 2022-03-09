package com.example.practica2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch

const val EXTRA_DARK_MODE="com.example.myfirstapp.DARK_MODE"

class CambiarFondo : AppCompatActivity() {

    lateinit var switch : Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambiar_fondo)

        switch= findViewById(R.id.switch_cambiarFondo)
    }


    fun btEnviar(view: View){
        val data = Intent()

        data.putExtra(EXTRA_DARK_MODE, switch.isChecked)

        setResult(RESULT_OK, data)
        finish()
    }
}