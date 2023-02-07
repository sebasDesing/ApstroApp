package com.example.apstroapp.data.model.network
import com.example.apstroapp.data.model.model.AstroTypeModel
import retrofit2.Response
import retrofit2.http.GET

interface AstroApiClient {
        @GET("/api/astros/types")
        suspend fun getAstroTypes():Response <List<AstroTypeModel>>
}