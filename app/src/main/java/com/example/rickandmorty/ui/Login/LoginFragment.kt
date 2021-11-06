package com.example.rickandmorty.ui.Login

import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.databinding.FragmentLoginBinding


class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(FragmentLoginBinding::inflate) {

    override fun getViewModel()= LoginViewModel::class.java
    override var useSharedViewModel=false

    override fun start() {

    }
}