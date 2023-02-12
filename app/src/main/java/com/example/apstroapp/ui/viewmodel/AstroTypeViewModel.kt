package com.example.apstroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apstroapp.domain.GetAstroRandonUseCase
import com.example.apstroapp.domain.GetAstroTypesUseCase
import com.example.apstroapp.domain.model.AstroType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AstroTypeViewModel @Inject constructor(
    private val getAstroUseCase: GetAstroTypesUseCase,
    private val getRandomUseCase: GetAstroRandonUseCase
) : ViewModel() {
    val astroModel = MutableLiveData<AstroType>()
    val isLoading = MutableLiveData<Boolean>()


    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAstroUseCase()
            if (!result.isNullOrEmpty()) {
                astroModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomAstro() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val astro = getRandomUseCase()
            if (astro != null) {
                astroModel.postValue(astro)
            }
            isLoading.postValue(false)
        }

    }


}