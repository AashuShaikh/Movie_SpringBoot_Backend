package com.aashushaikh.movie_backend.database.services

import com.aashushaikh.movie_backend.database.models.MovieBookmark
import com.aashushaikh.movie_backend.database.repositories.MovieBookmarkRepository
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MovieBookmarkService(
    private val bookmarkRepo: MovieBookmarkRepository
) {
    fun addBookmark(userId: ObjectId, movieId: String, title: String?, posterUrl: String?) {
        // Avoid duplicates
        if (bookmarkRepo.findByUserIdAndMovieId(userId, movieId) != null) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Movie is Already Bookmarked")
        }

        val bookmark = MovieBookmark(
            movieId = movieId,
            title = title,
            posterUrl = posterUrl,
            userId = userId
        )
        bookmarkRepo.save(bookmark)
    }

    fun getBookmarks(userId: ObjectId): List<MovieBookmark> {
        return bookmarkRepo.findByUserId(userId)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "No Movie Bookmarked")
    }

    fun removeBookmark(userId: ObjectId, movieId: String): Boolean {
        val deleted = bookmarkRepo.deleteByUserIdAndMovieId(userId, movieId)
        return deleted > 0
    }
}
