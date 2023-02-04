package com.example.apstroapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.apstroapp.databinding.ActivityMainBinding
import com.example.apstroapp.viewmodel.AstroTypeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val astroViewModel: AstroTypeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        astroViewModel.astroModel.observe(this, Observer { current_Astro ->
            binding.textLibro.text = current_Astro.quote
            binding.author.text = current_Astro.author
        })

        binding.viewContainer.setOnClickListener{
            astroViewModel.randomAstro()
        }

    }
}