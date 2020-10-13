package com.example.recyclerviewmvvm.ui.movies


import android.view.View
import com.example.recyclerviewmvvm.data.models.Movie

interface RecyclerviewClickListerner {
    fun onRecyclerviewOnItemClick(view: View, movie: Movie)
}