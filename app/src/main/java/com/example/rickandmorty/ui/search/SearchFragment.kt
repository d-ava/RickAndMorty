package com.example.rickandmorty.ui.search

import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(FragmentSearchBinding::inflate) {

    override fun getViewModel()=SearchViewModel::class.java

    override var useSharedViewModel=false

    override fun start() {

    }
}