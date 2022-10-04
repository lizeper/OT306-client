package com.melvin.ongandroid.view.ui.notifications

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.melvin.ongandroid.data.SlideRepository
import com.melvin.ongandroid.model.Imagen

class NotificationsViewModel : ViewModel() {

    val slideRepository= SlideRepository()
    var prueba:MutableLiveData<List<Imagen>> =MutableLiveData()

  fun get() {

      val p=Imagen(13,"imagen2","https://cdn.pixabay.com/photo/2016/05/10/21/50/meditation-1384758_960_720.jpg","ppppp")
      val pruebaimagen=Imagen(12,"imagen1","https://image.shutterstock.com/image-illustration/colorful-aura-meditation-concept-illustration-600w-1926486164.jpg","mmmmmm")
      val pr=Imagen(14,"imagen3","https://cdn.pixabay.com/photo/2015/12/09/01/02/mandalas-1084082_960_720.jpg","popopopo")
      val prue=Imagen(15,"imagen3","https://cdn.pixabay.com/photo/2016/12/06/01/26/colour-1885352_960_720.jpg","popo0popo")
      val listaprueba= listOf<Imagen>(pruebaimagen,p,pr,prue)


      val listaImagenes:MutableList<Imagen> = mutableListOf()


      listaprueba.forEach(){
          if(listaImagenes.size<3){
              listaImagenes.add(it)
          }

      }
      prueba.postValue(listaImagenes)

      //slideRepository.getAllSlides() {
          ///no olvidar no olvidar postvalue es el retorno al activity no olvidar
        //  prueba.postValue(it.imagen)
      }

}