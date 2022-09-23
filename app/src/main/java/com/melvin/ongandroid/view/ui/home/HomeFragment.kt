package com.melvin.ongandroid.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
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

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        //esto es para que quede horizontal la imagen del recycle
        val recycle=binding.recicleHome

        val layoutManager=LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,true
        )
        recycle.layoutManager=layoutManager

        val apadter=HomeAdapter(listOf("luna","lunera","Martes"),object :HomeAdapter.HomeListener{
            override fun select(imagenes: String) {

            }

        })
        binding.recicleHome.adapter=apadter
        return root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}