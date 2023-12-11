package com.example.mentoria_pokedex

data class Pokemon (
    val number: Int,
    val name:String,
//    val url:String,
    val types: List<PokemonType>
)

{
    val formattedNumber = number.toString().padStart(3,'0')
    val imagenUrl= "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"


}

