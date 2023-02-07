package com.example.apstroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apstroapp.data.model.AstroProvider
import com.example.apstroapp.data.model.model.AstroTypeModel
import com.example.apstroapp.domain.GetAstroRandonUseCase
import com.example.apstroapp.domain.GetAstroTypesUseCase
import kotlinx.coroutines.launch

class AstroTypeViewModel : ViewModel() {
    val astroModel = MutableLiveData<AstroTypeModel>()
    val isLoading = MutableLiveData<Boolean>()
    var getAstroUseCase = GetAstroTypesUseCase()
    var getRandomUseCase = GetAstroRandonUseCase()
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAstroUseCase()
            if(!result.isNullOrEmpty()) {
                astroModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
    fun randomAstro() {

        isLoading.postValue(true)
        val astro =getRandomUseCase()
        if (astro!=null){
            astroModel.postValue(astro)
        }
        isLoading.postValue(false)
    }


}