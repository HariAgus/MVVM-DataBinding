package com.example.recyclerviewmvvm.data.repositories

import com.example.recyclerviewmvvm.data.network.MoviesApi

class MoviesRepository(private val api: MoviesApi) : SafeApiRequest() {
    suspend fun getMovies() = apiRequest {
        api.getMovies()
    }
}