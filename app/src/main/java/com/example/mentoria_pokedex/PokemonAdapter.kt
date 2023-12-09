package com.example.mentoria_pokedex

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)

        return ViewHolder(view)
    }

    //

    override fun getItemCount() = items.size
//    override fun getItemCount(): Int {
//        return items.size
//    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }
    //qual ViewHolder esta aparecendo e qual a posicao dele

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("WrongViewCast")
        fun bindView(item: Pokemon) {
            val ivPokemon = itemView.findViewById<ImageView>(R.id.ivPokemon)
            val tvNumber = itemView.findViewById<TextView>(R.id.tvNumber)
            val tvName = itemView.findViewById<TextView>(R.id.tvName)
            val tvType1 = itemView.findViewById<TextView>(R.id.tvType1)
            val tvType2 = itemView.findViewById<TextView>(R.id.tvType2)

            //TODO: Load image with Glide
            tvNumber.text = "N ${item.number}"
            tvName.text = item.name
            tvType1.text = item.types[0].name

            if (item.types.size >1) {
                tvType2.visibility = View.VISIBLE
                tvType2.text = item.types[1].name
            } else {
                tvType2.visibility = View.GONE
            }
        }
    }

}