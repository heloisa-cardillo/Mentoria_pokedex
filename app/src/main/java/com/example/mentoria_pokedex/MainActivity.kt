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
        Thread {
            loadPokemon()
        }.start()
    }
    private fun loadPokemon() {
        val pokemonsApiResult = PokemonRepository.listPokemons()
        pokemonsApiResult?.results?.let {
            val pokemons: List<Pokemon?> = it.map {
                val number = it.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()

                val pokemonApiResult= PokemonRepository.getPokemon("")


                pokemonApiResult?.let {
                    Pokemon (
                        pokemonApiResult.id,
                        pokemonApiResult.name.capitalize(),
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
        }}}


//private fun loadPokemon() {
//    PokemonRepository.listPokemons(10, object : PokemonRepository.ListPokemonResultsListener {
//        override fun onPokemonListRetrieved(value: PokemonsApiResult?) {
//            value?.let {
//                val pokemons: List<Pokemon?> = it.results.map { pokemonResult ->
//                    val number = pokemonResult.url
//                        .replace("https://pokeapi.co/api/v2/pokemon/", "")
//                        .replace("/", "").toInt()
//
//                    PokemonRepository.getPokemon(pokemonResult.url) { pokemonApiResult ->
//                        pokemonApiResult?.let {
//                            Pokemon(
//                                pokemonApiResult.id,
//                                pokemonApiResult.name.capitalize(),
//                                pokemonApiResult.types.map { PokemonType(it.name) }
//                            )
//                        }
//                    }
//                }
//
//                val layoutManager = LinearLayoutManager(this@MainActivity)
//                recyclerView.post {
//                    recyclerView.layoutManager = layoutManager
//                    recyclerView.adapter = PokemonAdapter(pokemons)
//                }
//            }
//        }
//    })
//}