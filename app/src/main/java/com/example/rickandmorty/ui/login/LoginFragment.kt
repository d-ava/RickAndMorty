package com.example.rickandmorty.ui.login

import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentLoginBinding
import com.example.rickandmorty.ui.register.RegisterFragment


class LoginFragment :
    BaseFragment<FragmentLoginBinding, LoginViewModel>(FragmentLoginBinding::inflate) {

    override fun getViewModel() = LoginViewModel::class.java
    override var useSharedViewModel = false

    override fun start() {
        setListeners()
    }


    private fun setListeners(){
        binding.btnLogIn.setOnClickListener {

         findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
        }

        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_global_registerFragment)
        }

    }

}