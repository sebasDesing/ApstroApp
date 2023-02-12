package com.example.apstroapp.data.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.apstroapp.domain.model.AstroType


@Entity(tableName = "typeAstro_table")
data class AstroTypeEntiti(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "typeAstro") val typeAstro: String,
    @ColumnInfo(name = "imageUrl") val imageUrl: String


)

fun AstroType.toDB() = AstroTypeEntiti(typeAstro = typeAstro, imageUrl = imgUrl)