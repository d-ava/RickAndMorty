package com.example.rickandmorty.ui.home

import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmorty.BaseFragment
import com.example.rickandmorty.CharacterAdapter
import com.example.rickandmorty.CharacterPagingAdapter
import com.example.rickandmorty.LoadingStateAdapter
import com.example.rickandmorty.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {


    override fun getViewModel() = HomeViewModel::class.java

    override var useSharedViewModel = false
    lateinit var adapter: CharacterAdapter


    private val characterPagingAdapter = CharacterPagingAdapter()


    override fun start() {


        setRecycler2()
        setObservers2()
        setListeners2()
        setSwipeListener2()
        //setRecycler()
        //loadCharactersFlow()
        //loadCharactersLiveData()

    }

    private fun setRecycler2() {
        binding.recycler.layoutManager = GridLayoutManager(context, 2)
        binding.recycler.adapter = characterPagingAdapter.withLoadStateFooter(
            footer = LoadingStateAdapter()
        )
    }

    private fun setObservers2() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadCharactersFlow().collectLatest {
                characterPagingAdapter.submitData(it)

            }
        }
    }

    private fun setListeners2() {
        viewLifecycleOwner.lifecycleScope.launch {
            characterPagingAdapter.loadStateFlow.collectLatest {
                binding.progressbar.isVisible = it.refresh is LoadState.Loading
                binding.progressBarOut.isVisible = it.refresh is LoadState.Loading
            }
        }
    }

    private fun setSwipeListener2(){
        binding.swipe.setOnRefreshListener {
            viewLifecycleOwner.lifecycleScope.launch {
                characterPagingAdapter.loadStateFlow.collectLatest {
                    binding.swipe.isRefreshing = it.refresh is LoadState.Loading
                }
            }
        }
    }

/*    private fun loadCharactersLiveData() {
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
    }*/


}