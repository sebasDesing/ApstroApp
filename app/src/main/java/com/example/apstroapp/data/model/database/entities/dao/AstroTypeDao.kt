package com.example.apstroapp.data.model.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.apstroapp.data.model.database.entities.AstroTypeEntiti

@Dao
interface AstroTypeDao {
    @Query("SELECT * FROM typeAstro_table ")
    suspend fun  geAstroTypes():List<AstroTypeEntiti>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(astros: List<AstroTypeEntiti> )
    @Query("DELETE FROM typeAstro_table")
    suspend fun deleteAllAstroTypes()
}