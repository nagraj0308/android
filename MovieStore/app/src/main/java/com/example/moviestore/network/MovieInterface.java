package com.example.moviestore.network;

import com.example.moviestore.movie.MovieDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieInterface {
        @GET("/movie/popular")
        void getPopularMovies(Callback<Movies.MovieResult>cb);

}
