package com.aashushaikh.movie_backend.external

import org.springframework.stereotype.Service

@Service
class TmdbService(
    private val tmdbClient: TmdbClient,
    private val props: TmdbProperties
) {
    fun getPopularMovies(): List<Result> {
        return tmdbClient.getPopularMovies(props.apiKey).results
    }
}
