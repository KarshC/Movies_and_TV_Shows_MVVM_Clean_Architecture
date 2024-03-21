package com.example.moviesandtvshows.presentation.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.moviesandtvshows.R
import com.example.moviesandtvshows.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
    private lateinit var tvShowBinding: ActivityTvShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvShowBinding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
    }
}