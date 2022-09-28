package com.melvin.ongandroid.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Slide(

    @SerializedName("success")
    val success:Boolean,
    @SerializedName("data")
    val imagen:List<Imagen>
): Serializable
