package com.example.rickandmorty.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private var _binding:FragmentSplashBinding? = null
    private val binding get()=_binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSplashBinding.inflate(inflater, container, false)


        binding.intro.alpha=0f

        binding.intro.animate().setDuration(3000).alpha(1f).withEndAction{

            findNavController().navigate(R.id.action_splashFragment_to_navHomeFragment)
        }




        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}