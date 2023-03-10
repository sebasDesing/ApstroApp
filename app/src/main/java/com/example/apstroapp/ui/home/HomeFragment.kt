package com.example.apstroapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apstroapp.ui.home.adapter.AstroTypeAdapter
import com.example.apstroapp.data.model.model.AstroTypeModel
import com.example.apstroapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRv()
    }

    private fun initRv() {
        val superList = listOf(
            AstroTypeModel("name1", "asaad"),
            AstroTypeModel("name22222", "asaad"),
            AstroTypeModel("name333333", "asaad"),
        )

        val manager = LinearLayoutManager(requireContext())
        val decoration = DividerItemDecoration(requireContext(), manager.orientation)

        binding.recyclerView.layoutManager =   manager
        binding.recyclerView.adapter = AstroTypeAdapter(superList) { astro -> onItemSelect(astro)}
        binding.recyclerView.addItemDecoration(decoration)
    }

    private fun onItemSelect(astro:AstroTypeModel) {
        Toast.makeText(requireContext(), astro.typeAstro, Toast.LENGTH_SHORT).show()
    }

}
