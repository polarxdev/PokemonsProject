package com.example.pokemonsproject

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonsproject.databinding.ItemPokemonBinding

class PokemonListAdapter(
    private var pokemons: List<Pokemon>, val listener: Listener
): RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {
    private var onClickListener: OnClickListener? = null
    class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var binding: ItemPokemonBinding = ItemPokemonBinding.bind(itemView)
        fun bind(pokemon: Pokemon, listener: Listener) = with(binding){
            name.setText(pokemon.name)
            photo.setImageResource(pokemon.photo)

            itemView.setOnClickListener{
                listener.onClick(pokemon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonListViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(pokemons[position], listener)
    }
    override fun getItemCount(): Int = pokemons.size

    interface Listener {
        fun onClick(pokemon: Pokemon)
    }
}