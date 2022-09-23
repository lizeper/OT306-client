package com.melvin.ongandroid.view.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.databinding.ItemHomeBinding

class HomeAdapter(
    var listOfString:List<String>,
    val listener:HomeListener
    ):RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    interface HomeListener{
        fun select(imagenes: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        //inflar la vista de  un item de la lista y crear una viewholder*****se utiliza siempre que queremos auna nueva vista
        val layoutInflater=LayoutInflater.from(parent.context)
        val binding=ItemHomeBinding.inflate(layoutInflater,parent,false)
        return HomeViewHolder(binding,listener)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
       // actualizar los datos
       holder.bind(listOfString.get(position))
    }

    override fun getItemCount(): Int {
    //scroll para mostrar al usaurio
        return listOfString.size
    }

    class HomeViewHolder(private val binding: ItemHomeBinding,val listener:HomeListener):RecyclerView.ViewHolder(binding.root){
        fun bind(imagenes: String) {

            binding.textoPrueba.text = imagenes

            binding.root.setOnClickListener {
                listener.select(imagenes)
            }
        }
    }
}