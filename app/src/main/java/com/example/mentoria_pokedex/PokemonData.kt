package com.example.mentoria_pokedex
open class PokemonsApiResult (
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String,
    val id: Int,
    val types: List<PokemonSlotType> ,
    var onUrlClickListener: (() -> Unit)? = null
)


data class PokemonApiResult(
    val id:Int,
    val name: String,
    val types: List<PokemonSlotType>
)
data class PokemonType (
    val name: String
)

data class PokemonSlotType(
    val type: PokemonType
)
data class Pokemon (
    val number: Int,
    val name:String,
    val types: List<PokemonType>,
    val formattedNumber: String = number.toString().padStart(3,'0'),
    val imagenUrl: String = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
)
{

}