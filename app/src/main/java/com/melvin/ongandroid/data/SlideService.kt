package com.melvin.ongandroid.data

import android.util.Log
import com.melvin.ongandroid.model.Slide
import retrofit2.Call
import retrofit2.http.GET
import kotlin.math.log

interface SlideService {

    //obtener GET las imagenes de la api

    @GET("api/slides")
    fun getAllSlides(): Call<Slide>


    @GET("api/news")
    fun getNews(): Call<Slide>


}