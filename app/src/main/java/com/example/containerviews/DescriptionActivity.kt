package com.example.containerviews

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_description.*

class DescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        val passedPokemon = intent?.getParcelableExtra<Pokemon>(KEY_POKEMON)
        tvPokemonName.text = "Name: " + passedPokemon?.name ?: "Unknown"
        tvPokemonType.text = "Type: " + passedPokemon?.type ?: "Unknown"
        tvPokemonMove.text = "Signature Move: " + passedPokemon?.signatureMove ?: "Unknown"
    }

    fun makeSound(view: View)
    {
        var mediaPlayer: MediaPlayer? = MediaPlayer.create(this, R.raw.charmander)
        mediaPlayer?.start()
    }
}