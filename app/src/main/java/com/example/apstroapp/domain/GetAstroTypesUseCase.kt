package com.example.apstroapp.domain

import com.example.apstroapp.data.model.AstroRepository
import com.example.apstroapp.data.model.model.AstroTypeModel

class GetAstroTypesUseCase {

    private val repository = AstroRepository()

    suspend operator fun invoke(): List<AstroTypeModel>? = repository.getAastrosTypes()

}