package com.example.mentoria_pokedex

class PokemonsApiResult (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val name: String,
    val types: PokemonTypeSlot
)

data class PokemonTypeSlot (
    val slot: Int,val type: PokemonType
)