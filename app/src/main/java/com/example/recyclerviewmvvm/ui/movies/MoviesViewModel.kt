package com.example.recyclerviewmvvm.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewmvvm.util.Coroutines
import com.example.recyclerviewmvvm.data.models.Movie
import com.example.recyclerviewmvvm.data.repositories.MoviesRepository
import kotlinx.coroutines.Job

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<Movie>>()
    val movies : LiveData<List<Movie>>
    get() = _movies

    fun getMovies() {
        job= Coroutines.ioThenMain({
            repository.getMovies()
        }, {
            _movies.value = it
        }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}