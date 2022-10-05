package com.melvin.ongandroid.data

import android.util.Log
import com.melvin.ongandroid.RetrofitService
import com.melvin.ongandroid.model.Slide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {

    fun getAllNews(onResponse:(news:Slide)->Unit){

        val serviceNews= RetrofitService.instance
        //el metodo create recibe la interface qque creamos en este caso slideService
            .create(SlideService::class.java)
            .getNews()


        serviceNews.enqueue(object:Callback<Slide> {
            override fun onResponse(call: Call<Slide>, response: Response<Slide>) {
                val slideNews=response.body()


                if(response.isSuccessful && slideNews != null) {

                    onResponse(slideNews)
                   /// Log.e("liz","$slideNews")
                }

            }

            override fun onFailure(call: Call<Slide>, t: Throwable) {
               var message = t.message ?: "Error inesperado"
                Log.e("liz","$message")
            }

        })
    }
}