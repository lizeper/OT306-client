package com.melvin.ongandroid.view.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.melvin.ongandroid.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    companion object{
        const val KEY_HOME = "KEY_HOME"
    }

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding?=null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

       /* val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it*/

        //esto es para que quede horizontal la imagen del recycle
        val recycle=binding.recicleHome

        val layoutManager=LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,true
        )
        recycle.layoutManager=layoutManager



        val adapter=HomeAdapter(listOf())

        binding.recicleHome.adapter=adapter

        homeViewModel.slideLD.observe(viewLifecycleOwner,{
            adapter.listOfString=it
            //notificar que los datos cambiaron
            adapter.notifyDataSetChanged()
            //si la lista esta vacia no  muestre nada
            if (it.isEmpty()){
                binding.recicleHome.visibility=View.GONE
            }
            //Log.e("liz","${it}")
        })


        homeViewModel.getSlide()
        return  root



    }

    //aqui se pueden llamar los servicios porque la vista esta creada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getSlide()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}