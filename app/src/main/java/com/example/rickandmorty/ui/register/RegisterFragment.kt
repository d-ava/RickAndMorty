package com.example.rickandmorty.ui.register

import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.databinding.FragmentRegisterBinding

class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterViewModel>(FragmentRegisterBinding::inflate) {

    override fun getViewModel() = RegisterViewModel::class.java

    override var useSharedViewModel = false

    override fun start() {

    }
}