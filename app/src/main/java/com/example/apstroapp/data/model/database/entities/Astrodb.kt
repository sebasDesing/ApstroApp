package com.example.apstroapp.data.model.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.apstroapp.data.model.database.entities.dao.AstroTypeDao

@Database(entities = [AstroTypeEntiti::class], version = 1)
abstract class Astrodb : RoomDatabase() {
    abstract fun getAstroTypeDao(): AstroTypeDao
}