package com.example.mentoria_pokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        recyclerView = findViewById(R.id.rvPokemons)
//
//        val pidgeot = Pokemon(
//            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/018.png",
//            4,
//            "Pidgeot",
//            listOf(
//                PokemonType("Flying")
//            )
//
//        )
//        val pokemons = listOf(
//            pidgeot, pidgeot, pidgeot, pidgeot
//        )

        Thread(Runnable {
            loadPokemon()
        }).start()

    }

    private fun loadPokemon() {
        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            val pokemons: List<Pokemon> = it.map {
             val number =
            }

            val layoutManager = LinearLayoutManager(this)
            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonAdapter(pokemons)

            }
        }
    }
}