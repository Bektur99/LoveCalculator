package com.example.a4month_lesson6hw6.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface LoveApi {

    @GET("getPercentage")
    fun calculatePercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "41c32082efmsh6b641a3e23321e7p162ec3jsn1a50fd0d9126",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}