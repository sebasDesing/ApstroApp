package com.example.apstroapp.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apstroapp.R
import com.example.apstroapp.adapter.AstroTypeAdapter
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
        setList(view)
        progressBar()
        configSwipe()
    }


    @SuppressLint("ResourceAsColor")
    private fun configSwipe() {
        binding.swipeHome.setOnRefreshListener {
            binding.swipeHome.setColorSchemeColors(R.color.white, R.color.teal_200)
            val layoutManager = LinearLayoutManager(requireContext())
            val itemDecorator =
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            astroViewModel.onReload(
                layoutManager,
                itemDecorator,
                binding.recyclerView,
                AstroTypeAdapter()
            )
            Handler(Looper.getMainLooper()).postDelayed(
                { binding.swipeHome.isRefreshing = false }, 5000
            )

        }
    }


    private fun setList(view: View) {
        astroViewModel.onCreate(AstroTypeAdapter(), view, requireContext())
    }

    private fun progressBar() {
        astroViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
        })
    }
}
