package com.example.pokemonsproject

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val bundle:Bundle? = intent.extras
        val id = bundle?.getInt("id")

        val data = hashMapOf(
            1 to hashMapOf(
                "name" to R.string.bulbasaur,
                "weight" to "6.9",
                "height" to "70",
                "category" to "Seed",
                "abilities" to "Overgrow",
                "type" to "Grass / Poison",
                "photo" to R.drawable.bulbasaur
            ),
            2 to hashMapOf(
                "name" to R.string.charmelion,
                "weight" to "19",
                "height" to "110",
                "category" to "Flame",
                "abilities" to "Blaze",
                "type" to "Fire",
                "photo" to R.drawable.charmelion
            ),
            3 to hashMapOf(
                "name" to R.string.caterpie,
                "weight" to "2.9",
                "height" to "30",
                "category" to "Worm",
                "abilities" to "Shield Dust",
                "type" to "Bug",
                "photo" to R.drawable.caterpie
            )
        )

        id.let {
            val pokeData = data[it]
            if (pokeData != null){
                binding.name.text = getString(pokeData["name"] as Int)
                binding.weight.text = pokeData["weight"].toString()
                binding.height.text = pokeData["height"].toString()
                binding.category.text = pokeData["category"].toString()
                binding.abilities.text = pokeData["abilities"].toString()
                binding.type.text = pokeData["type"].toString()
                binding.photo.setImageResource(pokeData["photo"] as Int)
            }
            else{
                Log.d("pokeData", "pokeData is null")
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
