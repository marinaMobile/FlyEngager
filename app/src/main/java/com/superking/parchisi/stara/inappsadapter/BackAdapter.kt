package com.superking.parchisi.stara.inappsadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.superking.parchisi.stara.R

class BackAdapter (gamesList: List<ShopClass>):
    RecyclerView.Adapter<BackAdapter.GameViewHolder>() {



    val gamesListi : List<ShopClass> = gamesList


    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder (itemView){
        var imagePoster: ImageView
        var titleGame: TextView
        var textCategory: TextView
        init {
            imagePoster = itemView.findViewById(R.id.imageGame)
            titleGame = itemView.findViewById(R.id.titleGame)
            textCategory  = itemView.findViewById(R.id.textCat)


        }

        fun setGame(game: ShopClass) {
            imagePoster.setImageResource(game.poster)
            titleGame.text = game.nameOfBack
            textCategory.text = game.category
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vp_shop, parent, false)
        return GameViewHolder(view)
    }



    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.setGame(gamesListi[position])


    }

    override fun getItemCount(): Int {
        return gamesListi.size
    }
}