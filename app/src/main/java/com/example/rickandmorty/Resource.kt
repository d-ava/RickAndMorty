package com.example.rickandmorty

sealed class Resource<out T>(
    val data: T? = null,
    val msg: String? = null,
    val loading: Boolean? = null
) {

    class Success<T>(data: T, loading: Boolean? = false) :
        Resource<T>(data = data, loading = loading)

    class Error<T>(message: String, data: T? = null, loading: Boolean? = false) : Resource<T>(
        data = data,
        msg = message, loading= loading
    )
    class Loading<T> (loading: Boolean): Resource<T>(loading = loading)

    class Empty <T>: Resource<T>()
}
