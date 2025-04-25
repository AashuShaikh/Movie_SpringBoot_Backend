package com.aashushaikh.movie_backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class MovieBackendApplication

fun main(args: Array<String>) {
	runApplication<MovieBackendApplication>(*args)
}
