package com.example.pokemonsproject

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class PokemonsData(
    val id: Int,
    @StringRes val name: Int,
    val weight: Double,
    val height: Double,
    val category: String,
    val abilities: String,
    val type: String,
    @DrawableRes val photo: Int
)

object Pokemon{
    private val pokemons = listOf(
        PokemonsData(
            id = 1,
            name = R.string.bulbasaur,
            weight = 6.9,
            height = 70.0,
            category = "Seed",
            abilities = "Overgrow",
            type = "Grass / Poison",
            photo = R.drawable.bulbasaur
        ),
        PokemonsData(
            id = 2,
            name = R.string.charmelion,
            weight = 19.0,
            height = 110.0,
            category = "Flame",
            abilities = "Blaze",
            type = "Fire",
            photo = R.drawable.charmelion
        ),
        PokemonsData(
            id = 3,
            name = R.string.caterpie,
            weight = 2.9,
            height = 30.0,
            category = "Worm",
            abilities = "Shield Dust",
            type = "Bug",
            photo = R.drawable.caterpie
        ),
    ).associateBy { it.id }
    fun getPokemon(id : Int) = pokemons[id]

    fun getPokemonsList() = pokemons
}
