package com.example.apstroapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apstroapp.R
import com.example.apstroapp.data.model.model.AstroTypeModel

class AstroTypeAdapter : RecyclerView.Adapter<AstroTypeViewHolder>() {

    private val astroTypes = mutableListOf<AstroTypeModel>()
    fun setList(astroTypeList: List<AstroTypeModel>) {
        astroTypes.clear()
        astroTypes.addAll(astroTypeList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstroTypeViewHolder {
        val context = parent.context
        val infater = LayoutInflater.from(context)
        val view = infater.inflate(R.layout.item_astro_type, parent, false)
        return AstroTypeViewHolder(view)
    }

    override fun getItemCount(): Int = astroTypes.size

    override fun onBindViewHolder(holder: AstroTypeViewHolder, position: Int) {
        holder.bind(astroTypes[position])
    }
}