package com.example.pokemonsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonsproject.databinding.ItemPokemonBinding

class PokemonListAdapter(val pokemonClickListener: PokemonClickListener):
    RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {

    private var pokemons = emptyList<Pokemon>()

    class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding: ItemPokemonBinding = ItemPokemonBinding.bind(itemView)
        fun bind(pokemon: Pokemon, clickListener: PokemonClickListener) = with(binding){
            name.setText(pokemon.name)
            photo.setImageResource(pokemon.photo)

            itemView.setOnClickListener{
                clickListener.onClick(pokemon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(pokemons[position], pokemonClickListener)
    }
    override fun getItemCount(): Int = pokemons.size

    fun setData(newPokemonsList: List<Pokemon>){
        val diffUtil = MyDiffUtil(pokemons, newPokemonsList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        pokemons = newPokemonsList
        diffResults.dispatchUpdatesTo(this)
    }

    fun interface PokemonClickListener {
        fun onClick(pokemon: Pokemon)
    }

}