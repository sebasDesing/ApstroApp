package com.example.apstroapp.data.model

import com.example.apstroapp.data.model.model.AstroTypeModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AstroProvider @Inject constructor() {
    var astros: List<AstroTypeModel> = emptyList()
}