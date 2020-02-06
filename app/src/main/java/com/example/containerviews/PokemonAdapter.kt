package com.example.containerviews

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonAdapter(val pokemonList : ArrayList<Pokemon>) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.populateItem(pokemonList[position])
    }


    override fun getItemCount() = pokemonList.size

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        fun populateItem(pokemon: Pokemon)
        {
            itemView.tvPokemonName.text = pokemon.name
            itemView.setOnClickListener {
                val intent = Intent(it.context, DescriptionActivity::class.java)
                intent.putExtra(KEY_POKEMON, pokemon)
                it.context.startActivity(intent)
            }
        }

    }
}