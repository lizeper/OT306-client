package com.melvin.ongandroid.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Imagen(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name:String,
    @SerializedName("image")
    val image:String,
    @SerializedName("description")
    val description:String,

): Serializable
