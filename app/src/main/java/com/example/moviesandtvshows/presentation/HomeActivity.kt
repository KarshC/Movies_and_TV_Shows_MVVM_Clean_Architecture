package com.example.moviesandtvshows.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.moviesandtvshows.R
import com.example.moviesandtvshows.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
}