package com.aashushaikh.movie_backend.database.repositories

import com.aashushaikh.movie_backend.database.models.RefreshToken
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface RefreshTokenRepository: MongoRepository<RefreshToken, ObjectId>