package com.example.practica2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.RatingBar
import android.widget.TextView


const val EXTRA_VALORACION = "com.example.myfirstapp.VALORACION"

class Valorar : AppCompatActivity() {

    lateinit var ratingbar: RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_valorar)

        ratingbar = findViewById<RatingBar>(R.id.ratingBar)

        ratingbar.setOnRatingBarChangeListener { ratingBar, fl, b ->

            setupRatingBarWithChanges(ratingBar)



        }
    }

    fun btEnviar(view: View){
        val data = Intent()

        data.putExtra(EXTRA_VALORACION, ratingbar.rating)

        setResult(RESULT_OK, data)
        finish()
    }






    fun setupRatingBarWithChanges(ratingbar: RatingBar) {


        setRatingText(numStars = ratingbar.numStars)

        ratingbar.setOnRatingBarChangeListener { ratingBar, rating, _ ->
            setRatingText(rating, ratingBar.numStars)
        }
    }

    fun setRatingText(rating: Float = 0f, numStars: Int) {

        val ratingText = findViewById<TextView>(R.id.rating_text)
        ratingText.text = formatRating(rating, numStars)

    }

    fun formatRating(rating: Float, numStars: Int) = "$rating/${numStars}"



}