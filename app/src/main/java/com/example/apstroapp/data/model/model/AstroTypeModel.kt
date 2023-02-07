package com.example.apstroapp.data.model.model

import com.google.gson.annotations.SerializedName

data class AstroTypeModel(
    @SerializedName("type_astro") val typeAstro: String,
    @SerializedName("img_type_astrourl") val imageUrl: String
)
