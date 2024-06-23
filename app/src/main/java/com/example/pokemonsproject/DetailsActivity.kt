package com.example.pokemonsproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonsproject.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.comebackButton.setOnClickListener{
            onBackPressed()
        }

        val pokemon = Pokemon.getPokemon(intent.getIntExtra("id", 1))

        with(binding){
            pokemon?.let{pokemon ->
                name.text = getString(pokemon.name)
                weight.text = pokemon.weight.toString()
                height.text = pokemon.height.toString()
                category.text = pokemon.category
                abilities.text = pokemon.abilities
                type.text = pokemon.type
                photo.setImageResource(pokemon.photo)
            }?: run{
                Log.d("pokeData", "pokeData is null")
                Toast.makeText(this@DetailsActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}