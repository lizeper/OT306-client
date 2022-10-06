package com.melvin.ongandroid.view.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.ongandroid.data.SlideRepository
import com.melvin.ongandroid.model.Imagen

class HomeViewModel : ViewModel() {
    val slideRepository=SlideRepository()

    val slideLD:MutableLiveData<List<Imagen>> = MutableLiveData()

    fun getSlide(){
      //slideLD.postValue(emptyList())
      //Log.e("liz","lista vacia ${slideLD}")

      slideRepository.getAllSlides(){
           ///no olvidar no olvidar postvalue es el retorno al activity no olvidar
         slideLD.postValue(it.imagen)
       //    Log.e("liz","${it}")
        }

    }
}


