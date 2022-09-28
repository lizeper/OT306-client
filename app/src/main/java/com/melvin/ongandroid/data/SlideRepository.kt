package com.melvin.ongandroid.data

import android.util.Log
import com.melvin.ongandroid.RetrofitService
import com.melvin.ongandroid.model.Imagen
import com.melvin.ongandroid.model.Slide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SlideRepository {

    //aqui el listener sirve para llamar los eventos y para comunicarse con el view model
    fun getAllSlides(onResponse: (slide:Slide)->Unit){
            //instancio a retrofit
        val service = RetrofitService.instance
            //el metodo create recibe la interface qque creamos en este caso slideService
            .create(SlideService::class.java)
            .getAllSlides()

        service.enqueue(object:Callback<Slide>{
            override fun onResponse(call: Call<Slide>, response: Response<Slide>) {

                val slide=response.body()

                if(response.isSuccessful && slide!=null ) {
                   onResponse(slide)


                  //  Log.e("liz","${slide.toString()}")
                }
            }

            override fun onFailure(call: Call<Slide>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }


}