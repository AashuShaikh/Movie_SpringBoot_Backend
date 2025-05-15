package com.aashushaikh.movie_backend.external

import com.aashushaikh.movie_backend.external.models.detail.TmdbDetailResponse
import com.aashushaikh.movie_backend.external.models.list.TmdbMovieResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "tmdb", url = "\${tmdb.base-url}")
interface TmdbClient {

    @GetMapping("/movie/popular")
    fun getPopularMovies(
        @RequestParam("api_key") apiKey: String
    ): TmdbMovieResponse

    @GetMapping("/movie/{id}")
    fun getMovieById(
        @PathVariable("id") movieId: Int,
        @RequestParam("api_key") apiKey: String
    ): TmdbDetailResponse
}
