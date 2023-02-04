package com.example.apstroapp.data.model.network
import com.example.apstroapp.data.model.model.AstroTypeModel
import retrofit2.Response
import retrofit2.http.GET

interface AstroApiClient {
        @GET("/.json")
        suspend fun getAstroTypes():Response <List<AstroTypeModel>>
}