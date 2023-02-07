package com.example.apstroapp.data.model.network

import com.example.apstroapp.core.RetrofitHelper
import com.example.apstroapp.data.model.model.AstroTypeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AstroService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getAstroTypes(): List<AstroTypeModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(AstroApiClient::class.java).getAstroTypes()
            response.body() ?: emptyList()
        }
    }
}