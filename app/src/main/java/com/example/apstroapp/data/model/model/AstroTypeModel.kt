package com.example.apstroapp.data.model.model

import com.google.gson.annotations.SerializedName

data class AstroTypeModel(
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)
