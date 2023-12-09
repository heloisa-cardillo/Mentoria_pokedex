package com.example.mentoria_pokedex

data class Pokemon (
    val imagenUrl:String,
    val number: Int,
    val name:String,
    val types: List<PokemonType>
)

