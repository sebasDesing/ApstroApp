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

                    "Error : 500 ",
                    "https://www.elegantthemes.com/blog/wp-content/uploads/2020/06/000-501-http-error.png"
                )
            )
        }
    }


}