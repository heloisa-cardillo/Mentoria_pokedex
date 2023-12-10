package com.example.mentoria_pokedex

data class Pokemon (
    val imagenUrl:String,
    val number: Int,
    val name:String,
//    val url:String,
    val types: List<PokemonType>
)

{
    val formattedNumber = number.toString().padStart(3,'0')
}

