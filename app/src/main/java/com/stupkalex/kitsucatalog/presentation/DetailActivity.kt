package com.stupkalex.kitsucatalog.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.stupkalex.kitsucatalog.databinding.AnimeItemDetailActivityBinding

private lateinit var binding: AnimeItemDetailActivityBinding
private lateinit var viewModel: DetailViewModel

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AnimeItemDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(DetailViewModel::class.java)
        setupViewValue()


    }

    private fun setupViewValue() {
        val animeItemId = intent.getIntExtra(EXTRA_FROM_ID, 0)
        viewModel.getAnimeItem(animeItemId)
        viewModel.getAnimeItem(animeItemId).observe(this) {
            with(binding) {
                tvTitle.text = it.title
                tvRating.text = String.format("%s / 100",it.averageRating)
                tvReleaseDate.text = it.startDate
                tvAgeRating.text = String.format("%s : %s", it.ageRating, it.ageRatingGuide)
                tvEpisodeCount.text = it.episodeCount.toString()
                tvDescription.text = it.description
                Picasso.get().load(it.bigPoster).into(ivBigPoster)
                val url = it.youtubeVideoId
                ivTrailer.setOnClickListener {
                    val trailerIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://www.youtube.com/watch?v=$url")
                    )
                    startActivity(trailerIntent)
                }
            }
        }
    }

    companion object {
        private const val EXTRA_FROM_ID = "animeId"

        fun newIntent(context: Context, animeId: Int): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_FROM_ID, animeId)
            return intent
        }
    }
}