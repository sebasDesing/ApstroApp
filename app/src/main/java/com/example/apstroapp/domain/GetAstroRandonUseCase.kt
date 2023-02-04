package com.example.apstroapp.domain

import com.example.apstroapp.data.model.AstroProvider
import com.example.apstroapp.data.model.model.AstroTypeModel

class GetAstroRandonUseCase {

    operator  fun invoke():AstroTypeModel?{
        val astros = AstroProvider.astros
        if(!astros.isNullOrEmpty()){
            val randomNumber =(astros.indices).random()
            return astros[randomNumber]
        }
        return  null
    }
}