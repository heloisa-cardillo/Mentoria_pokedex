package com.example.mentoria_pokedex
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object PokemonRepository {
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PokemonService::class.java)
    }


    fun getAllPokemons(callback: ListPokemonResultsListener, vararg range:Int) {
        val call = service.getPokemon(10)
        //colocar um for. 10 que ta numero do pokemon
        call.enqueue(object : Callback<PokemonsApiResult> {
            override fun onResponse(
                call: Call<PokemonsApiResult>,
                response: Response<PokemonsApiResult>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()
                    callback.onPokemonListRetrieved(result)
                } else {
                    callback.onPokemonListRetrieved(null)
                }
            }


            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
//                callback.onPokemonListRetrieved(null)
                //criar callback erro
            }
        })
    }
    interface ListPokemonResultsListener {
        fun onPokemonListRetrieved(
            value: PokemonsApiResult?
        )
    }
}



//    fun listPokemons(limit: Int = 10, callback: ListPokemonResultsListener) {
//        val call = service.listPokemons(limit)
//        call.enqueue(object : Callback<PokemonsApiResult> {
//            override fun onResponse(
//                call: Call<PokemonsApiResult>,
//                response: Response<PokemonsApiResult>
//            ) {
//                if (response.isSuccessful) {
//                    val results = response.body()
//                    callback.onPokemonListRetrieved(results)
//                } else {
//                    callback.onPokemonListRetrieved(null)
//                }
//            }
//
//            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
//                callback.onPokemonListRetrieved(null)
//            }
//        })
//    }
//
//    fun getPokemon(number: Int, callback: (PokemonApiResult?) -> Unit) {
//        val call = PokemonRepository.service.getPokemon(number)
//        call.enqueue(object : Callback<PokemonApiResult> {
//            override fun onResponse(
//                call: Call<PokemonApiResult>,
//                response: Response<PokemonApiResult>
//            ) {
//                if (response.isSuccessful) {
//                    val result = response.body()
//                    callback(result)
//                } else {
//                    callback(null)
//                }
//            }
//
//            override fun onFailure(call: Call<PokemonApiResult>, t: Throwable) {
//                callback(null)
//            }
//        })
//    }
