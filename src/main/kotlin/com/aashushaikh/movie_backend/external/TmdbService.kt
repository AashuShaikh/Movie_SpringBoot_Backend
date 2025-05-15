package com.aashushaikh.movie_backend.external

import com.aashushaikh.movie_backend.external.models.detail.DetailResponse
import com.aashushaikh.movie_backend.external.models.detail.TmdbDetailResponse
import com.aashushaikh.movie_backend.external.models.list.Result
import com.aashushaikh.movie_backend.external.models.mapper.toDetailResponse
import org.springframework.stereotype.Service

@Service
class TmdbService(
    private val tmdbClient: TmdbClient,
    private val props: TmdbProperties
) {
    fun getPopularMovies(): List<Result> {
        return tmdbClient.getPopularMovies(props.apiKey).results
    }

    fun getMovieById(movieId: Int): DetailResponse {
        val response = tmdbClient.getMovieById(movieId = movieId, apiKey = props.apiKey)
        return response.toDetailResponse()
    }
}
