package com.example.apstroapp.data.model

import com.example.apstroapp.data.model.model.AstroTypeModel
import com.example.apstroapp.data.model.network.AstroService

class AstroRepository {
    private val api = AstroService()
    suspend fun getAastrosTypes(): List<AstroTypeModel> {
        val response = api.getAstroTypes()
        AstroProvider.astros = response //bd local
        return response
    }
}