package com.example.recyclerviewmvvm.data.network

import com.example.recyclerviewmvvm.data.models.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    @GET("movies")
    suspend fun getMovies() : Response<List<Movie>>

    companion object {
        operator fun invoke() : MoviesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build()
                .create(MoviesApi::class.java)

        }
    }

}