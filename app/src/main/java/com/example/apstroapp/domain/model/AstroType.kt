package com.example.apstroapp.domain.model


import com.example.apstroapp.data.model.database.entities.AstroTypeEntiti
import com.example.apstroapp.data.model.model.AstroTypeModel

data class AstroType(val typeAstro: String, val imgUrl: String)

fun AstroTypeModel.toDomain() = AstroType(typeAstro, imageUrl)
fun AstroTypeEntiti.toDomain() = AstroType(typeAstro, imageUrl)
