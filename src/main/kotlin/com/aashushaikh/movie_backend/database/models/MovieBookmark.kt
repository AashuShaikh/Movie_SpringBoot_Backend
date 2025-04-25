package com.aashushaikh.movie_backend.database.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("movie_bookmarks")
data class MovieBookmark(
    @Id
    val id: ObjectId = ObjectId.get(),
    val movieId: String,
    val title: String?,
    val posterUrl: String?,
    val userId: ObjectId
)
