package com.example.rickandmorty.ui.Search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(FragmentSearchBinding::inflate) {

    override fun getViewModel()=SearchViewModel::class.java

    override var useSharedViewModel=false

    override fun start() {

    }
}