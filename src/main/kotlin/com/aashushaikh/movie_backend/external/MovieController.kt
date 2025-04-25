package com.aashushaikh.movie_backend.external

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/movies")
class MovieController(
    private val tmdbService: TmdbService
) {

    @GetMapping("/popular")
    fun getPopular(): List<Result> = tmdbService.getPopularMovies()
}
