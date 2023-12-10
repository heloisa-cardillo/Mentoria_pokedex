package com.example.mentoria_pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mentoria_pokedex.ui.theme.Mentoria_pokedexTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView (R.layout.main_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)

        val pidgeot = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/018.png",
            4,
            "Pidgeot",
            listOf(
                PokemonType("Flying")
            )

        )
        val pokemons = listOf(
            pidgeot, pidgeot, pidgeot, pidgeot
        )

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter= PokemonAdapter(pokemons)
    }
}