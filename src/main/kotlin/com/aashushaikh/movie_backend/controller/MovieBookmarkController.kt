package com.aashushaikh.movie_backend.controller

import com.aashushaikh.movie_backend.database.models.MovieBookmark
import com.aashushaikh.movie_backend.database.services.MovieBookmarkService
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/api/bookmarks")
class MovieBookmarkController(
    private val bookmarkService: MovieBookmarkService
) {

    data class BookmarkRequest(
        val movieId: String,
        val title: String?,
        val posterUrl: String?
    )

    data class BookmarkResponse(
        val id: String,
        val movieId: String,
        val title: String?,
        val posterUrl: String?
    )

    @PostMapping
    fun addBookmark(
        @RequestBody request: BookmarkRequest,
    ) {
        val userId = SecurityContextHolder.getContext().authentication.principal as String
        bookmarkService.addBookmark(ObjectId(userId), request.movieId, request.title, request.posterUrl)
    }

    @GetMapping
    fun getBookmarks(principal: Principal): List<BookmarkResponse> {
        val userId = SecurityContextHolder.getContext().authentication.principal as String
        val bookmarks = bookmarkService.getBookmarks(ObjectId(userId))
        return bookmarks.map { it.toBookmarkResponse() }
    }

    @DeleteMapping("/{movieId}")
    fun deleteBookmark(
        @PathVariable movieId: String,
    ): ResponseEntity<Unit> {
        val userId = SecurityContextHolder.getContext().authentication.principal as String
        val removed = bookmarkService.removeBookmark(ObjectId(userId), movieId)
        return if (removed) ResponseEntity.ok().build()
        else ResponseEntity.notFound().build()
    }
}

fun MovieBookmark.toBookmarkResponse(): MovieBookmarkController.BookmarkResponse {
    return MovieBookmarkController.BookmarkResponse(
        id = id.toHexString(),
        movieId = movieId,
        title = title,
        posterUrl = posterUrl
    )
}
