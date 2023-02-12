package com.example.apstroapp.data.model


import com.example.apstroapp.data.model.database.entities.AstroTypeEntiti
import com.example.apstroapp.data.model.database.entities.dao.AstroTypeDao
import com.example.apstroapp.data.model.model.AstroTypeModel
import com.example.apstroapp.data.model.network.AstroService
import com.example.apstroapp.domain.model.AstroType
import com.example.apstroapp.domain.model.toDomain
import javax.inject.Inject

class AstroRepository @Inject constructor(
    private val api: AstroService,
    private val AstroTypeDao: AstroTypeDao
) {

    suspend fun getAastrosTypesFromApi(): List<AstroType> {
        val response: List<AstroTypeModel> = api.getAstroTypes()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getAstroTypesFromDB(): List<AstroType> {
        val response = AstroTypeDao.geAstroTypes()
        return response.map {
            it.toDomain()
        }
    }
    suspend fun insertAstroTypes(astroTypes:List<AstroTypeEntiti>){
        AstroTypeDao.insertAll(astroTypes)
    }

    suspend fun  clearAstroTypes(){
        AstroTypeDao.deleteAllAstroTypes()
    }
}