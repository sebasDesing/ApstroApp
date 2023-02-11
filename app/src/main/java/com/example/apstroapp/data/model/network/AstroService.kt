package com.example.apstroapp.data.model.network

import com.example.apstroapp.core.RetrofitHelper
import com.example.apstroapp.data.model.model.AstroTypeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AstroService @Inject constructor(private  val api :   AstroApiClient){
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getAstroTypes(): List<AstroTypeModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAstroTypes()
            response.body() ?: emptyList()
        }
    }
}