package com.example.rickandmorty.ui.characterDetails

import androidx.fragment.app.Fragment
import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.databinding.FragmentCharacterDetailsBinding

class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding, CharacterDetailsViewModel>(FragmentCharacterDetailsBinding::inflate) {

    override fun getViewModel()= CharacterDetailsViewModel::class.java

    override var useSharedViewModel=false

    override fun start() {

    }
}