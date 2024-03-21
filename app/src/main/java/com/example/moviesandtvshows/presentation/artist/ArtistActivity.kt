package com.example.moviesandtvshows.presentation.artist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.moviesandtvshows.R
import com.example.moviesandtvshows.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {
    private lateinit var artistBinding: ActivityArtistBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        artistBinding = DataBindingUtil.setContentView(this, R.layout.activity_artist)

    }
}