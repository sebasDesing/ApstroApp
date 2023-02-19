package com.example.apstroapp.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apstroapp.R
import com.example.apstroapp.data.model.model.AstroTypeModel

class AstroTypeViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
fun bind(item: AstroTypeModel){
    val textName:TextView = itemView.findViewById(R.id.textViewNameAstro)
    val textUrl:TextView = itemView.findViewById(R.id.textViewUrl)
    textName.text = item.typeAstro
    textUrl.text = item.imageUrl
}

}