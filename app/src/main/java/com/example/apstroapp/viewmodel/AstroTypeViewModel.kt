package com.example.apstroapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apstroapp.model.AstroProvider
import com.example.apstroapp.model.AstroTypeModel

class AstroTypeViewModel : ViewModel() {
    val astroModel = MutableLiveData<AstroTypeModel>()
    fun randomAstro() {
        val currentAstro = AstroProvider.random()
        astroModel.postValue(currentAstro)

    }
}