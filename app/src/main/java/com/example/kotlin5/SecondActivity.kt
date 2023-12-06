package com.example.kotlin5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val anime = mutableListOf<Anime>()
    private val animeListAdapter = AnimeListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillAnimeList()
        setupRecyclerView()
    }

    private fun fillAnimeList() {
        anime.apply {
            add(Anime(R.drawable.img, "Магия и мускулы"))
            add(Anime(R.drawable.img_1, "Клинок рассекающий демонов"))
            add(Anime(R.drawable.img_2, "Рагна багровый"))
            add(Anime(R.drawable.img_3, "Нежить и неудача"))
            add(Anime(R.drawable.img_4, "Боец баки"))
            add(Anime(R.drawable.img_5, "Семья шпиона"))
            add(Anime(R.drawable.img_6, "Паразит"))
            add(Anime(R.drawable.img_7, "История о Моноке"))
        }
    }

    private fun setupRecyclerView() {
        binding.animeImage.adapter = animeListAdapter
        animeListAdapter.setData(anime)

    }
}