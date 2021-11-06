package com.example.rickandmorty.ui.Register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentRegisterBinding

class RegisterFragment :
    BaseFragment<FragmentRegisterBinding, RegisterViewModel>(FragmentRegisterBinding::inflate) {

    override fun getViewModel() = RegisterViewModel::class.java

    override var useSharedViewModel = false

    override fun start() {

    }
}