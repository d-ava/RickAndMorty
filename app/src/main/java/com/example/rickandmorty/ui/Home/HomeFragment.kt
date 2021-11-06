package com.example.rickandmorty.ui.Home

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.CharacterAdapter
import com.example.rickandmorty.Resource
import com.example.rickandmorty.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collect

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {


    override fun getViewModel() = HomeViewModel::class.java

    override var useSharedViewModel = false
    lateinit var adapter: CharacterAdapter


    override fun start() {

        setRecycler()
        loadCharactersFlow()
        //loadCharactersLiveData()

    }

    private fun loadCharactersLiveData() {
        viewModel.loadCharactersLiveData()
        viewModel.charactersLiveData.observe(viewLifecycleOwner) {

            adapter.setData(it.body()!!)
        }
    }

    private fun loadCharactersFlow() {
        viewModel.loadCharacterFlow()
        lifecycleScope.launchWhenStarted {
            viewModel.charactersFlow.collect {
                when (it) {
                    is Resource.Success -> {

                        adapter.setData(it.data!!)
                    }
                    is Resource.Error -> {
                        Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Loading -> {
                        binding.swipe.isRefreshing = it.loading!!
                        progressbar(it.loading!!)
                    }
                    else -> Unit


                }
            }
        }

        binding.swipe.setOnRefreshListener {
            viewModel.loadCharacterFlow()
        }
    }


    private fun setRecycler() {
        adapter = CharacterAdapter()
        val layoutManager = GridLayoutManager(context, 2)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = layoutManager
    }

    private fun progressbar(bool: Boolean) {
        binding.progressbar.isVisible = bool
    }
}