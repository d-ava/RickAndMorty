package com.example.rickandmorty.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.rickandmorty.RickAndMortyPagingSource

class HomeViewModel: ViewModel() {

/*    private val _charactersLiveData = MutableLiveData<Response<RickAndMorty>>()
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
    }*/

    fun loadCharactersFlow()=Pager(
        config = PagingConfig(pageSize = 1),
        pagingSourceFactory = {RickAndMortyPagingSource()}

    ).flow.cachedIn(viewModelScope)

}