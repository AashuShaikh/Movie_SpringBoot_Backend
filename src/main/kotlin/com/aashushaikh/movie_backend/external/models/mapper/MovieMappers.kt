package com.aashushaikh.movie_backend.external.models.mapper

import com.aashushaikh.movie_backend.external.models.detail.DetailResponse
import com.aashushaikh.movie_backend.external.models.detail.TmdbDetailResponse

fun TmdbDetailResponse.toDetailResponse(): DetailResponse{
    return DetailResponse(
        adult = adult ?: false,
        backdrop_path = backdrop_path ?: "",
        genres = genres?.mapNotNull { it.name } ?: emptyList(),
        id = id ?: 0,
        origin_country = origin_country ?: emptyList(),
        original_language = original_language ?: "",
        original_title = original_title ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        poster_path = poster_path ?: "",
        release_date = release_date ?: "",
        runtime = runtime ?: 0,
        spoken_languages = spoken_languages?.mapNotNull { it.english_name } ?: emptyList(),
        title = title ?: "",
        video = video ?: false,
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: 0
    )
}