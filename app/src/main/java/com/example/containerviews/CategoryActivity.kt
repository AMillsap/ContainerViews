package com.example.containerviews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity()
{
    val list by lazy{initList()}
    var pokemonList : ArrayList<Pokemon> = populateList()
    var filteredList : ArrayList<Pokemon> = ArrayList<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        initListView()
    }

    fun initListView()
    {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)

        lvListView.adapter = adapter
        lvListView.setOnItemClickListener{ _, _, i, _ ->
            val intent = Intent(this, ListOfAnimalsActivity::class.java)
            filteredList = pokemonList.filter { it.type == list[i]} as ArrayList<Pokemon>
            intent.putParcelableArrayListExtra(KEY_POKEMON, filteredList)
            startActivity(intent)
        }
    }

    fun initList() : ArrayList<String>
    {
        val stringList = ArrayList<String>()
        stringList.add("Fire")
        stringList.add("Water")
        stringList.add("Ground")
        stringList.add("Electric")
        stringList.add("Psychic")
        return stringList
    }


    private fun populateList() : ArrayList<Pokemon>
    {
        val returnList = ArrayList<Pokemon>()

        returnList.add(Pokemon("Pikachu", "Electric", "Volt Tackle"))
        returnList.add(Pokemon("Jolteon", "Electric", "Thunderbolt"))
        returnList.add(Pokemon("Yamper", "Electric", "Nuzzle"))
        returnList.add(Pokemon("Charmander", "Fire", "Flamethrower"))
        returnList.add(Pokemon("Vulpix", "Fire", "Fire Fang"))
        returnList.add(Pokemon("Magmar", "Fire", "Fire Wheel"))
        returnList.add(Pokemon("Poliwhirl", "Water", "Whirlpool"))
        returnList.add(Pokemon("Squirtle", "Water", "Bubble"))
        returnList.add(Pokemon("Shellder", "Water", "Dive"))
        returnList.add(Pokemon("Diglett", "Ground", "Dig"))
        returnList.add(Pokemon("Sandshrew", "Ground", "Sand Attack"))
        returnList.add(Pokemon("Cubone", "Ground", "Earthquake"))
        returnList.add(Pokemon("Mr.Mime", "Psychic", "Psybeam"))
        returnList.add(Pokemon("Abra", "Psychic", "Teleport"))
        returnList.add(Pokemon("Drowzee", "Psychic", "Hypnosis"))

        return returnList
    }

}
