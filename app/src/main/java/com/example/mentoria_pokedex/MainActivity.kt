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

        Thread(Runnable {
            loadPokemon()
        }).start()

    }

    private fun loadPokemon() {
        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            val pokemons: List<Pokemon?> = it.map {
                val number = it.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()

                val pokemonApiResult= PokemonRepository.getPokemon(number)


                pokemonApiResult?.let {
                    Pokemon (
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map {
                            PokemonType("socorro")

                        })

                }


            }

            val layoutManager = LinearLayoutManager(this)
            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonAdapter(pokemons)

            }
        }
    }
}