package com.example.mentoria_pokedex

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit:Int): retrofit2.Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number")number: Int) : retrofit2.Call<PokemonApiResult>
}

//https://pokeapi.co/api/v2/pokemon/?limit=151