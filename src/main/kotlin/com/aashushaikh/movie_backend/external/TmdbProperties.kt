package com.aashushaikh.movie_backend.external

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@ConfigurationProperties(prefix = "tmdb")
@Configuration
data class TmdbProperties(
    var apiKey: String = "",
    var baseUrl: String = ""
)