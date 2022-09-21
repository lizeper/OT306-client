package com.melvin.ongandroid.view.ui.contact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.melvin.ongandroid.databinding.FragmentContactBinding

class ContactFragment : Fragment() {


    private lateinit var contactViewModel:ContactViewModel
    private var _binding:FragmentContactBinding?=null

    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       contactViewModel=ViewModelProvider(this)[ContactViewModel::class.java]

        _binding= FragmentContactBinding.inflate(inflater,container,false)
        val root: View = binding.root

        val textView:TextView=binding.textContact
        contactViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text=it
        })
        return root

    }



}