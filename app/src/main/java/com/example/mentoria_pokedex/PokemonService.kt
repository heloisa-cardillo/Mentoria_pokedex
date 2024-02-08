package com.example.mentoria_pokedex

import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonService {


//    @GET("pokemon")
//    fun listPokemons(@Query("limit") limit:Int): retrofit2.Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number: Int, i: Int) : retrofit2.Call<PokemonApiResult>

//    @GET
//    fun getPokemon(@Url url: String) : retrofit2.Call<PokemonApiResult>
}


// type = number
//https://pokeapi.co/api/v2/pokemon/?limit=151