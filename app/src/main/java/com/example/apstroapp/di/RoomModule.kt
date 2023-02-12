package com.example.apstroapp.di

import android.content.Context
import androidx.room.Room
import com.example.apstroapp.data.model.database.entities.Astrodb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private  const val ASTRO_TYPE_DB_NAME= "astro_types"

    @Singleton
    @Provides
    fun provifrRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, Astrodb::class.java, ASTRO_TYPE_DB_NAME).build()
    @Singleton
    @Provides
    fun provideAstroTypeDao(bd: Astrodb)= bd.getAstroTypeDao()
}