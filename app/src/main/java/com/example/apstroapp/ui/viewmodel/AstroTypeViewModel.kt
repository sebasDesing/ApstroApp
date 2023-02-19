package com.example.apstroapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apstroapp.adapter.AstroTypeAdapter
import com.example.apstroapp.data.model.model.AstroTypeModel
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


    fun onCreate(adapter: AstroTypeAdapter) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAstroUseCase()
            if (!result.isNullOrEmpty()) {
                adapter.setList(result.map {
                    AstroTypeModel(
                        typeAstro = it.typeAstro,
                        imageUrl = it.imgUrl
                    )
                })
                isLoading.postValue(false)
            }
        }
    }


    fun randomAstro() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val astro = getRandomUseCase()
            if (astro != null) {
                //astroModel.postValue(astro)

            }
            isLoading.postValue(false)
        }

    }




}