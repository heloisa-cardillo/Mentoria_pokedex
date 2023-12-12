package com.example.mentoria_pokedex

class PokemonsApiResult (
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val id:Int,
    val name: String,
    val types: List<PokemonType>
)

data class PokemonType (
    val name: String
)