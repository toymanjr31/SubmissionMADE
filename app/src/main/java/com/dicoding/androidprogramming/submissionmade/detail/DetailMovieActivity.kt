package com.dicoding.androidprogramming.submissionmade.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.androidprogramming.submissionmade.R
import com.dicoding.androidprogramming.submissionmade.core.domain.model.Movies
import com.dicoding.androidprogramming.submissionmade.databinding.ActivityDetailMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailMovieViewModel: DetailMovieViewModel by viewModel()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailMovies = intent.getParcelableExtra<Movies>(EXTRA_DATA)
        showDetailTourism(detailMovies)
    }

    private fun showDetailTourism(detailMovies: Movies?) {
        detailMovies?.let {
            val imageUrl = detailMovies.movieBackdrop
            supportActionBar?.title = detailMovies.movieTitle
            binding.content.tvDetailDescription.text = detailMovies.movieDescription
            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w780$imageUrl")
                .into(binding.ivDetailImage)

            var statusFavorite = detailMovies.movieFavorited
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovies(detailMovies, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}