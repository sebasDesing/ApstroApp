package com.example.apstroapp.domain.AstroTypeUseCases

import com.example.apstroapp.data.model.AstroRepository
import com.example.apstroapp.data.model.database.entities.toDB
import com.example.apstroapp.domain.model.AstroType
import javax.inject.Inject

class GetAstroTypesUseCase @Inject constructor(private val repository: AstroRepository) {
    suspend operator fun invoke(): List<AstroType> {
        val astroTypes = repository.getAstroTypesFromDB()
        return if (astroTypes.isNotEmpty()) {
            astroTypes
        } else {
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
        }
    }


}