package com.aashushaikh.movie_backend.database.repositories

import com.aashushaikh.movie_backend.database.models.MovieBookmark
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface MovieBookmarkRepository : MongoRepository<MovieBookmark, ObjectId> {
    fun findByUserId(userId: ObjectId): List<MovieBookmark>?
    fun findByUserIdAndMovieId(userId: ObjectId, movieId: String): MovieBookmark?
    fun deleteByUserIdAndMovieId(userId: ObjectId, movieId: String): Long
}