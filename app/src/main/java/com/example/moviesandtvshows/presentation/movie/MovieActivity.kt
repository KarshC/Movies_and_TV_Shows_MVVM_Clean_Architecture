package com.example.moviesandtvshows.presentation.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.moviesandtvshows.R
import com.example.moviesandtvshows.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var movieBinding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
    }
}