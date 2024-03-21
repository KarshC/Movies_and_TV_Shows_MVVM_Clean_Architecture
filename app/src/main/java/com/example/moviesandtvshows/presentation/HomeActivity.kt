package com.example.moviesandtvshows.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviesandtvshows.R
import com.example.moviesandtvshows.databinding.ActivityHomeBinding
import com.example.moviesandtvshows.presentation.artist.ArtistActivity
import com.example.moviesandtvshows.presentation.movie.MovieActivity
import com.example.moviesandtvshows.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        dataBinding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        dataBinding.tvButton.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }
        dataBinding.artistButton.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }
    }
}