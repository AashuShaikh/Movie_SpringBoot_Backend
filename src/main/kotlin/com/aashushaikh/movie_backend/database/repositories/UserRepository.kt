package com.aashushaikh.movie_backend.database.repositories

import com.aashushaikh.movie_backend.database.models.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User, ObjectId> {

    fun findByEmail(email: String): User?

}