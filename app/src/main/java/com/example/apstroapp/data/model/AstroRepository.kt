package com.example.apstroapp.data.model

import com.example.apstroapp.data.model.model.AstroTypeModel
import com.example.apstroapp.data.model.network.AstroService
import javax.inject.Inject

class AstroRepository @Inject constructor(private val api : AstroService, private val astroProvider : AstroProvider){

    suspend fun getAastrosTypes(): List<AstroTypeModel> {
        val response = api.getAstroTypes()
        astroProvider.astros = response //bd local
        return response
    }
}