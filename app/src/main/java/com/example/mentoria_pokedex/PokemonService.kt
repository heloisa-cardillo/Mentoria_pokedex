package com.example.mentoria_pokedex

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface PokemonService {

    @GET("pokemon")
    fun listPokemons(@Query("limit") limit:Int): retrofit2.Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number")number: Int) : retrofit2.Call<PokemonApiResult>

    @GET
    fun getPokemon(@Url url: String) : retrofit2.Call<PokemonApiResult>
}


// type = number
//https://pokeapi.co/api/v2/pokemon/?limit=151