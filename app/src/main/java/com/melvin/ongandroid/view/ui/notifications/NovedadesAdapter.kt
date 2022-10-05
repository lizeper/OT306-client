package com.melvin.ongandroid.view.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin.ongandroid.databinding.ItemNovedadesBinding
import com.melvin.ongandroid.model.Imagen

class NovedadesAdapter(
   var listaNovedades:List<Imagen>
):RecyclerView.Adapter<NovedadesAdapter.NovedadesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovedadesViewHolder {
        var layoutInflater=LayoutInflater.from(parent.context)
        var binding=ItemNovedadesBinding.inflate(layoutInflater,parent,false)
        return NovedadesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NovedadesViewHolder, position: Int) {
      holder.bind(listaNovedades.get(position))
    }

    override fun getItemCount(): Int {
        return listaNovedades.size
    }

    class NovedadesViewHolder(private val binding: ItemNovedadesBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(slideNovedades:Imagen){

            binding.nameNovedades.text=slideNovedades.name



            Glide.with(binding.imagenNovedades)
                .load(slideNovedades.image)
                .centerCrop()
                .into(binding.imagenNovedades);


        }

    }
}

