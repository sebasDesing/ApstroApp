package com.example.apstroapp.domain

import com.example.apstroapp.data.model.AstroProvider
import com.example.apstroapp.data.model.model.AstroTypeModel
import javax.inject.Inject

class GetAstroRandonUseCase @Inject constructor(private  val astroProvider: AstroProvider) {

    operator  fun invoke():AstroTypeModel?{
        val astros = astroProvider.astros
        if(!astros.isNullOrEmpty()){
            val randomNumber =(astros.indices).random()
            return astros[randomNumber]
        }
        return  null
    }
}