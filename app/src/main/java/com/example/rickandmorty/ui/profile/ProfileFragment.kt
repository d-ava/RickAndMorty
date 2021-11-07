package com.example.rickandmorty.ui.profile

import androidx.fragment.app.Fragment
import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.databinding.FragmentProfileBinding


class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>(FragmentProfileBinding::inflate) {


    override fun getViewModel() = ProfileViewModel::class.java

    override var useSharedViewModel = false

    override fun start() {

    }
}