package com.example.mentoria_pokedex

class PokemonsApiResult (
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String,
    var onUrlClickListener: (() -> Unit)? = null
)


data class PokemonApiResult(
    val id:Int,
    val name: String,
    val types: List<PokemonType>
)

data class PokemonType (
    val name: String
)


data class Pokemon (
    val number: Int,
    val name:String,
    val types: List<PokemonType>
)

{
    val formattedNumber = number.toString().padStart(3,'0')
    val imagenUrl= "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"


}