package com.example.apstroapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.101:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
