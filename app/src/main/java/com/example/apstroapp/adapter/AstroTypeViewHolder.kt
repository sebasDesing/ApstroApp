package com.example.apstroapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apstroapp.R
import com.example.apstroapp.data.model.model.AstroTypeModel
import com.example.apstroapp.databinding.ItemAstroTypeBinding

class AstroTypeViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val bindign = ItemAstroTypeBinding.bind(itemView)
    fun bind(item: AstroTypeModel) {
        bindign.textViewNameAstro.text = item.typeAstro
        Glide.with(itemView.context).load(item.imageUrl).into(bindign.textViewUrl)

    }
}