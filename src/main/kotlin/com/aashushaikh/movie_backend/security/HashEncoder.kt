package com.aashushaikh.movie_backend.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

@Component
class HashEncoder {

    private val bCryptPasswordEncoder = BCryptPasswordEncoder()

    fun encode(raw: String): String = bCryptPasswordEncoder.encode(raw)

    fun matches(raw: String, hashed: String): Boolean = bCryptPasswordEncoder.matches(raw, hashed)

}