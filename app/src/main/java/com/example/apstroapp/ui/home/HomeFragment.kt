package com.example.apstroapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.apstroapp.databinding.FragmentHomeBinding
import com.example.apstroapp.ui.viewmodel.AstroTypeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val astroViewModel: AstroTypeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        astroViewModel.onCreate()
        astroViewModel.astroModel.observe(viewLifecycleOwner, Observer { current_Astro ->
            binding.textLibro.text = current_Astro.typeAstro
            Glide.with(this).load(current_Astro.imageUrl).into(binding.imgTypeAstro)
        })
        astroViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
        })

        binding.FragmenHomeContain.setOnClickListener{
            astroViewModel.randomAstro()
        }
    }

}