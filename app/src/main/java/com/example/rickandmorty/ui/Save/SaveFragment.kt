package com.example.rickandmorty.ui.Save

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentSaveBinding


class SaveFragment : BaseFragment<FragmentSaveBinding, SaveViewModel>(FragmentSaveBinding::inflate) {

    override fun getViewModel()=SaveViewModel::class.java

    override var useSharedViewModel = false

    override fun start() {

    }
}