package com.example.rickandmorty.ui.Home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.Resource

import com.example.rickandmorty.model.RickAndMorty
import com.example.rickandmorty.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

class HomeViewModel: ViewModel() {

    private val _charactersLiveData = MutableLiveData<Response<RickAndMorty>>()
    val charactersLiveData: LiveData<Response<RickAndMorty>> get() = _charactersLiveData

    fun loadCharactersLiveData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getCharacters()
            }
        }
    }

    private suspend fun getCharacters(){
        val response = NetworkClient.api.getCharacters()
        val body = response.body()
        if (response.isSuccessful && body != null){
            _charactersLiveData.postValue(response)
        }
    }


    private val _charactersFlow = MutableStateFlow<Resource<RickAndMorty>>(Resource.Empty())
    val charactersFlow: StateFlow<Resource<RickAndMorty>> = _charactersFlow

    fun loadCharacterFlow(){
        viewModelScope.launch {
            _charactersFlow.value = Resource.Loading(loading = true)
            try{
                withContext(IO){
                    val response = NetworkClient.api.getCharacters()
                    val body = response.body()
                    if (response.isSuccessful && body !=null){
                        _charactersFlow.value = Resource.Success(data = body, loading = true)
                    }else {
                        _charactersFlow.value =
                            Resource.Error(message = response.message().toString(), loading = true)
                    }
                }
            }catch (e:Exception){
                _charactersFlow.value = Resource.Error(message = e.message.toString())
            }finally {
                withContext(IO){
                    _charactersFlow.value = Resource.Loading(loading = false)
                }
            }

        }
    }

}