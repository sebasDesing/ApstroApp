package com.example.apstroapp.domain.AstroTypeUseCases

import com.example.apstroapp.data.model.AstroRepository
import com.example.apstroapp.domain.model.AstroType
import javax.inject.Inject

class GetAstroRandonUseCase @Inject constructor(private val repository: AstroRepository) {

    suspend operator fun invoke(): AstroType? {
        val astros = repository.getAstroTypesFromDB()
        if (!astros.isNullOrEmpty()) {
            val randomNumber = (astros.indices).random()
            return astros[randomNumber]
        }
        return null
    }
}