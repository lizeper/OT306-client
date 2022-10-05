package com.melvin.ongandroid.view.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.melvin.ongandroid.databinding.ItemHomeBinding
import com.melvin.ongandroid.model.Imagen

class HomeAdapter(
    var listOfString:List<Imagen>
    ):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        //inflar la vista de  un item de la lista y crear una viewholder*****se utiliza siempre que queremos auna nueva vista
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding=ItemHomeBinding.inflate(layoutInflater,parent,false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
       // actualizar los datos
       holder.bind(listOfString.get(position))
    }

    override fun getItemCount(): Int {
    //scroll para mostrar al usaurio
        return listOfString.size
    }

    class HomeViewHolder(private val binding: ItemHomeBinding):RecyclerView.ViewHolder(binding.root){
            fun bind(imagen: Imagen){

                binding.nameHome.text=imagen.name
                binding.description.text=imagen.description

                Glide.with(binding.imagenHome)
                    .load(imagen.image)
                    .centerCrop()
                    .into(binding.imagenHome);

            }
    }
}