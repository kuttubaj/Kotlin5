package com.example.kotlin5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin5.databinding.AnimeItemBinding

class AnimeListAdapter : RecyclerView.Adapter<AnimeListAdapter.AnimeViewHolder>() {

    private var anime = listOf<Anime>()

    fun setData(data: List<Anime>) {
        anime = data
    }

    class AnimeViewHolder(private val binding: AnimeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBing(manga: Anime) = with(binding) {
            animeView.setImageResource(manga.image)
            animeName.text = manga.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBing(anime[position])
    }

    override fun getItemCount(): Int {
        return anime.size

    }
}