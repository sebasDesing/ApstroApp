package com.example.apstroapp.domain.AstroTypeUseCases

import com.example.apstroapp.data.model.AstroRepository
import com.example.apstroapp.data.model.database.entities.toDB
import com.example.apstroapp.domain.model.AstroType
import javax.inject.Inject

class SRLAstroTypeUseCase @Inject constructor(private val repository: AstroRepository) {
    suspend operator fun invoke(): List<AstroType> {
        return try {
            val apiAstroTypes = repository.getAastrosTypesFromApi()
            if (apiAstroTypes.isNotEmpty()) {
                repository.clearAstroTypes()
                repository.insertAstroTypes(apiAstroTypes.map {
                    it.toDB()
                })
                apiAstroTypes
            } else {
                emptyList()

            }
        } catch (e: Exception) {
            listOf(
                AstroType(

                    "Error",
                    "Ocurrió un error al obtener los datos de la API: ${e.message}"
                )
            )
        }
    }


}