package com.example.renta

sealed class LoadingResult<out R> {
    data class Success<T>(val data: T, val isFromCache: Boolean = false) : LoadingResult<T>()
    data class Error(val error: Throwable) : LoadingResult<Nothing>()
    data class Loading(val progress: Int? = null) : LoadingResult<Nothing>()
}