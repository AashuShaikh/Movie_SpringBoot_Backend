package com.aashushaikh.movie_backend.external

data class TmdbMovieResponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)