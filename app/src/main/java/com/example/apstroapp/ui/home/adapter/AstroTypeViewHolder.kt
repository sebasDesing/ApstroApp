package com.example.apstroapp.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.apstroapp.data.model.model.AstroTypeModel
import com.example.apstroapp.databinding.ItemAstroTypeBinding

class AstroTypeViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemAstroTypeBinding.bind(itemView)
    fun render(astro:AstroTypeModel, onClickListener :(AstroTypeModel) ->Unit) {
        binding.textViewNameAstro.text = astro.typeAstro

        itemView.setOnClickListener {
            onClickListener(astro)
        }
    }
}