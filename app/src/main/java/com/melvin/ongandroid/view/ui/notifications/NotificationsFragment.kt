package com.melvin.ongandroid.view.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.databinding.FragmentNotificationsBinding
import com.melvin.ongandroid.model.Imagen

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this)[NotificationsViewModel::class.java]

        // Inflate the layout for this fragment
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recycleNovedades=binding.recycleNovedades

        val layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL , true)
        recycleNovedades.layoutManager=layoutManager

        val adapter=NovedadesAdapter(listOf())


        binding.recycleNovedades.adapter=adapter
       notificationsViewModel.prueba.observe(viewLifecycleOwner,{
           adapter.listaNovedades=it
           adapter.notifyDataSetChanged()
           binding.recycleNovedades.visibility=View.VISIBLE

          //Log.e("liz","${it}")
       })


        return root
    }

    //aqui se pueden llamar los servicios porque la vista esta creada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            notificationsViewModel.getSlideNews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}