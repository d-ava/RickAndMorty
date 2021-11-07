package com.example.rickandmorty

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmorty.model.RickAndMorty
import com.example.rickandmorty.network.NetworkClient

private const val STARTING_PAGE_INDEX = 1

class RickAndMortyPagingSource (): PagingSource<Int, RickAndMorty.Character>(){

    override fun getRefreshKey(state: PagingState<Int, RickAndMorty.Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)

        }

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMorty.Character> {
       val page:Int = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = NetworkClient.api.getCharacters(page)
            val body = response.body()

            if (response.isSuccessful && body != null){
                var prevPage: Int? = null
                var nextPage:Int? = null

                if(body.info.pages>page){
                    nextPage = page+1
                }
                if (page != STARTING_PAGE_INDEX)
                    prevPage = page -1
                    LoadResult.Page(
                       data= body.results, prevKey = prevPage, nextKey = nextPage
                    )
            }else{
                LoadResult.Error(Throwable())
            }
        }catch (e:Exception){
            LoadResult.Error(e)
        }




    }
}