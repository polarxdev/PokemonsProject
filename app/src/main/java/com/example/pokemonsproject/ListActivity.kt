package com.example.pokemonsproject

import android.content.Context
import android.content.Intent
import android.os.Build.VERSION
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonsproject.databinding.ActivityListBinding

class ListActivity : AppCompatActivity(), PokemonListAdapter.Listener {

    private lateinit var binding: ActivityListBinding
    private lateinit var pokemons: List<Pokemon>

    private val myAdapter = PokemonListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(this, RecyclerView.VERTICAL).apply {
                setDrawable(resources.getDrawable(R.drawable.divider))
            })

        pokemons = PokemonObj.getPokemonsList().values.toList()
        myAdapter.setData(pokemons)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            pokemons = PokemonObj.getPokemonsList().values.toList()
            adapter = myAdapter
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
