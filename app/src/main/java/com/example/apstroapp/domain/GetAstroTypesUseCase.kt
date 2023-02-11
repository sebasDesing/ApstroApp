package com.example.apstroapp.domain

import com.example.apstroapp.data.model.AstroRepository
import com.example.apstroapp.data.model.model.AstroTypeModel
import javax.inject.Inject

class GetAstroTypesUseCase @Inject constructor( private val repository :  AstroRepository) {



    suspend operator fun invoke(): List<AstroTypeModel>? = repository.getAastrosTypes()

}