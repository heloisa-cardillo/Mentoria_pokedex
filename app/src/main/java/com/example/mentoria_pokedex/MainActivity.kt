package com.example.mentoria_pokedex
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView?=null
    val adapter: PokemonAdapter by lazy { PokemonAdapter(mutableListOf()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        recyclerView = findViewById(R.id.rvPokemons)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager (this@MainActivity)
            adapter = this@MainActivity.adapter
        }
            loadPokemon()
    }
    private fun loadPokemon() {
       PokemonRepository.listPokemons(limit=2, object:
           PokemonRepository.ListPokemonResultsListener{
           override fun onPokemonListRetrieved(value: PokemonsApiResult?) {
               value?.results?.forEachIndexed { index, pokemonResult ->
                   PokemonRepository.getPokemon(number = index+1){ pokemonApiResult ->
                      val pokemon= pokemonApiResult?.let {
                           Pokemon (
                               pokemonApiResult.id,
                               pokemonApiResult.name.capitalize(),
                               pokemonApiResult.types.map {
                                   it.type
                               }
                               )
                       }

                       pokemon?.let { adapter.addPokemons(listOf(it)) }

                   }
               }
           }
       })
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