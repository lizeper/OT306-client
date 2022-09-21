package com.melvin.ongandroid.view.ui.contribute

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.get
import com.melvin.ongandroid.databinding.FragmentContributeBinding
import com.melvin.ongandroid.databinding.FragmentHomeBinding
import com.melvin.ongandroid.view.ui.home.HomeViewModel


class ContributeFragment : Fragment() {

    companion object {
       fun newInstance() = ContributeFragment()
    }

    private lateinit var contributeViewModel:ContributeViewModel
    private var _binding: FragmentContributeBinding?=null

    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contributeViewModel=
            ViewModelProvider(this).get(ContributeViewModel::class.java)

        _binding = FragmentContributeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textcontribute
        contributeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it

        })

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}


