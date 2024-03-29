package com.example.mentoria_pokedex
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity(), PokemonRepository.ListPokemonResultsListener {
    var recyclerView: RecyclerView? = null
    val adapter: PokemonAdapter by lazy { PokemonAdapter(mutableListOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        recyclerView = findViewById(R.id.rvPokemons)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
        loadPokemon()
    }

    private fun loadPokemon() {
        PokemonRepository.getAllPokemons(this,1,2,3,4,5,6,7,8,9,10)
    }

    override fun onPokemonListRetrieved(value: PokemonsApiResult?) {
        value?.results?.forEach { pokemonResult ->
            val pokemon = pokemonResult?.let {
                Pokemon(
                    pokemonResult.id,
                    pokemonResult.name.capitalize(),
                    pokemonResult.types.map {
                        it.type
                    }
                )
            }

            pokemon?.let { adapter.addPokemons(listOf(it)) }
        }
    }

}





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