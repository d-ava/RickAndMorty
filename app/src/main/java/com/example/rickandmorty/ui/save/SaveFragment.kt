package com.example.rickandmorty.ui.save

import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.databinding.FragmentSaveBinding


class SaveFragment : BaseFragment<FragmentSaveBinding, SaveViewModel>(FragmentSaveBinding::inflate) {

    override fun getViewModel()=SaveViewModel::class.java

    override var useSharedViewModel = false

    override fun start() {

    }
}