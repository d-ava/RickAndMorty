package com.example.rickandmorty.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentNavHomeBinding

class NavHomeFragment : Fragment() {

    private var _binding: FragmentNavHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNavHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.homeNavTab.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeScreen -> {binding.homeNavContainer.findNavController().navigate(R.id.toHomeScreen)
                true}
                R.id.profileScreen -> {binding.homeNavContainer.findNavController().navigate(R.id.toProfileScreen)
                true}
                R.id.saveScreen -> {binding.homeNavContainer.findNavController().navigate(R.id.toSaveScreen)
                true}
                R.id.searchScreen -> {binding.homeNavContainer.findNavController().navigate(R.id.toSearchScreen)
                true}
                else -> false
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}