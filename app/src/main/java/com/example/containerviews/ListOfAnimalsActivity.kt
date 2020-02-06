package com.example.containerviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_of_animals.*

class ListOfAnimalsActivity : AppCompatActivity()
{
    val adapter  by lazy{PokemonAdapter(pokemonList)}

    var pokemonList : ArrayList<Pokemon> = ArrayList<Pokemon>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_animals)
        pokemonList = intent.getParcelableArrayListExtra(KEY_POKEMON)
        initRecyclerView()
    }
    private fun initRecyclerView()
    {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rvPokemonList.layoutManager = layoutManager
        rvPokemonList.addItemDecoration((itemDecoration))
        rvPokemonList.adapter = adapter
    }

}
