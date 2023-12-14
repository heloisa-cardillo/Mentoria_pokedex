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



    fun listPokemons(limit: Int = 10, callback: ListPokemonResultsListener) {
        val call = service.listPokemons(limit)
        call.enqueue(object : Callback<PokemonsApiResult> {
            override fun onResponse(
                call: Call<PokemonsApiResult>,
                response: Response<PokemonsApiResult>
            ) {
                if (response.isSuccessful) {
                   val results=response.body()
                    callback.onPokemonListRetrieved(results)
                } else {
                    callback.onPokemonListRetrieved(null)
                }
            }
            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
                callback.onPokemonListRetrieved(null)
            }
        })
    }

    fun getPokemon(url: String, callback: (PokemonApiResult?) -> Unit) {
        val call = PokemonRepository.service.getPokemon(url)

        call.enqueue(object : Callback<PokemonApiResult> {
            override fun onResponse(
                call: Call<PokemonApiResult>,
                response: Response<PokemonApiResult>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()
                    callback(result)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<PokemonApiResult>, t: Throwable) {
                callback(null)
            }
        })
    }

    interface ListPokemonResultsListener {
         fun onPokemonListRetrieved(
            value: PokemonsApiResult?
        )
    }
}


// metodo retornando direto o resultado -> return call.execute().body() -> congela a thread principal
    // sincrona -> É mais eficiente e confiável do que a transmissão assíncrona
    // para transferir a grande quantidade de dados/ sem lacuna entre os dados
    // + rapida

//    fun listPokemons(limit: Int = 10): PokemonsApiResult? {
//        val call = service.listPokemons(limit)
//        return call.execute().body()
//    }
//
//    fun getPokemon(url: String): PokemonApiResult? {
//        val call = PokemonRepository.service.getPokemon(url)
//        return call.execute().body()
//
//    }
//}
//


//enqueue:trata-se de uma função que nos permite
// chamá-la em um ponto específico do código da mesma maneira como fizemos com a nossa interface

//https://pokeapi.co/api/v2/pokemon/?limit=151

//assincrona -> assíncrona, o intervalo de tempo da transmissão não é constante, é aleatório


//call.enqueue(object : Callback<PokemonsApiResult> {
//    override fun onResponse(
//        call: Call<PokemonsApiResult>,
//        response: Response<PokemonsApiResult>
//    ) {
//
//        if (response.isSuccessful) {
//            val body = response.body()
//            body?.results?.let{
//                Log.d("POKEMONS_API",it[0].name)
//
//            }
//        }
//    }
//
//}
//)