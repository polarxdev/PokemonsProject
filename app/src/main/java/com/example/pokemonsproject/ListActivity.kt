package com.example.pokemonsproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonsproject.databinding.ActivityListBinding

class ListActivity : AppCompatActivity(), PokemonListAdapter.Listener {

    private lateinit var binding: ActivityListBinding
    private lateinit var pokemons: List<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            pokemons = PokemonObj.getPokemonsList().values.toList()
            adapter = PokemonListAdapter(pokemons, this@ListActivity)
        }
    }

    fun setOnClickListenerForElement(id: Int){
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    override fun onClick(pokemon: Pokemon) {
        setOnClickListenerForElement(pokemon.id)
    }
}
