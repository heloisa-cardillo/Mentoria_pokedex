package com.example.mentoria_pokedex

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


    // metodo retornando direto o resultado -> return call.execute().body() -> congela a thread principal
    // sincrona -> É mais eficiente e confiável do que a transmissão assíncrona
    // para transferir a grande quantidade de dados/ sem lacuna entre os dados
    // + rapida

    fun listPokemons(limit: Int = 10): PokemonsApiResult? {
        val call = service.listPokemons(limit)
        return call.execute().body()
    }

    fun getPokemon(url: String): PokemonApiResult? {
        val call = PokemonRepository.service.getPokemon(url)
        return call.execute().body()

    }
}

interface ListPokemonResultsListener {
    fun onPokemonListRetrieved(
        value: PokemonsApiResult
    )
}

//enqueue:trata-se de uma função que nos permite
// chamá-la em um ponto específico do código da mesma maneira como fizemos com a nossa interface

//https://pokeapi.co/api/v2/pokemon/?limit=151

//assincrona -> assíncrona, o intervalo de tempo da transmissão não é constante, é aleatório

//        call.enqueue(object : Callback<PokemonsApiResult> {
//            override fun onResponse(
//                call: Call<PokemonsApiResult>,
//                response: Response<PokemonsApiResult>
//            ) {
//
//                if (response.isSuccessful) {
//                    val body = response.body()
//                    body?.results?.let{
//                        Log.d("POKEMONS_API",it[0].name)
//
//                    }
//                }
//                Log.d("POKEMON_API","Pokemons Carregados")
//            }
//
//            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
//               Log.e("POKEMON_API", "Erro ao carregar",t)
//            }
//
//        }
//        )
