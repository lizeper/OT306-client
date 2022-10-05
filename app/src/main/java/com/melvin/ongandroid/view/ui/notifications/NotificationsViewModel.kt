package com.melvin.ongandroid.view.ui.notifications

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.ongandroid.data.NewsRepository
import com.melvin.ongandroid.model.Imagen

class NotificationsViewModel : ViewModel() {

    val newsRepository= NewsRepository()
    var prueba:MutableLiveData<List<Imagen>> =MutableLiveData()

  fun getSlideNews() {
        newsRepository.getAllNews {
            prueba.postValue(it.imagen)


            //val listaImagenes:MutableList<Imagen> = mutableListOf()

          //  Log.e("liz","${it}")

        }



      //slideRepository.getAllSlides() {
          ///no olvidar no olvidar postvalue es el retorno al activity no olvidar
        //  prueba.postValue(it.imagen)
      }

}