package com.example.apstroapp.domain

import com.example.apstroapp.data.model.AstroRepository
import com.example.apstroapp.data.model.database.entities.toDB
import com.example.apstroapp.domain.model.AstroType
import javax.inject.Inject

class GetAstroTypesUseCase @Inject constructor(private val repository: AstroRepository) {


    suspend operator fun invoke(): List<AstroType> {
        val astroTypes = repository.getAastrosTypesFromApi()
        return if (astroTypes.isNotEmpty()) {
            repository.insertAstroTypes(astroTypes.map {
                repository.clearAstroTypes()
                it.toDB()
            })
            astroTypes
        } else {
            repository.getAstroTypesFromDB()
        }
    }


}