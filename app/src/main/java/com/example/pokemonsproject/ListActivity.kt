package com.example.pokemonsproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonsproject.databinding.ActivityListBinding

class ListActivity : AppCompatActivity(){

    private lateinit var binding: ActivityListBinding
    private lateinit var pokemons: List<Pokemon>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonClickListener = PokemonListAdapter.PokemonClickListener { pokemon ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("id", pokemon.id)
            startActivity(intent)
        }

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, RecyclerView.VERTICAL).apply {
                setDrawable(resources.getDrawable(R.drawable.divider))
            })

        val myAdapter = PokemonListAdapter(pokemonClickListener)

        pokemons = PokemonObj.getPokemonsList().values.toList()
        myAdapter.setData(pokemons)

        binding.recyclerView.apply {
            pokemons = PokemonObj.getPokemonsList().values.toList()
            adapter = myAdapter
        }
    }
}
