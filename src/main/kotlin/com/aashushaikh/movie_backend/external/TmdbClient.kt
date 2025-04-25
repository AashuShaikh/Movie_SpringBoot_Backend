package com.aashushaikh.movie_backend.external

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "tmdb", url = "\${tmdb.base-url}")
interface TmdbClient {

    @GetMapping("/movie/popular")
    fun getPopularMovies(
        @RequestParam("api_key") apiKey: String
    ): TmdbMovieResponse
}
