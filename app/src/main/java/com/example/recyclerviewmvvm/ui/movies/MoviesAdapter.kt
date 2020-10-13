package com.example.recyclerviewmvvm.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.data.models.Movie
import com.example.recyclerviewmvvm.databinding.RecyclerviewMovieBinding

class MoviesAdapter(private val movies: List<Movie>, private val listerner: RecyclerviewClickListerner) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.recyclerview_movie, parent, false)
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie = movies[position]
        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener {
            listerner.onRecyclerviewOnItemClick(holder.recyclerviewMovieBinding.buttonBook, movies[position])
        }
    }


    inner class MoviesViewHolder(val recyclerviewMovieBinding: RecyclerviewMovieBinding) :
        RecyclerView.ViewHolder(recyclerviewMovieBinding.root)


}