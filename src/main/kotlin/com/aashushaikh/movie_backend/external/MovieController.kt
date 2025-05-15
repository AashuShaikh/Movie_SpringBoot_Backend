package com.aashushaikh.movie_backend.external

import com.aashushaikh.movie_backend.external.models.detail.DetailResponse
import com.aashushaikh.movie_backend.external.models.list.Result
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/movies")
class MovieController(
    private val tmdbService: TmdbService
) {

    @GetMapping("/popular")
    fun getPopular(): List<Result> = tmdbService.getPopularMovies()

    @GetMapping("/movie/{id}")
    fun getPopular(
        @PathVariable("id") movieId: Int
    ): DetailResponse = tmdbService.getMovieById(movieId)
}
