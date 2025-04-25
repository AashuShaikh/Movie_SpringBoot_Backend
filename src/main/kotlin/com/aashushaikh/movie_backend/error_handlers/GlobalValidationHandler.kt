package com.aashushaikh.movie_backend.error_handlers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun validationHandler(e: MethodArgumentNotValidException): ResponseEntity<Map<String, Any>>{
        val errors = e.bindingResult.allErrors.map {
            it.defaultMessage ?: "Invalid Value"
        }
        return ResponseEntity.status(400).body(mapOf("errors" to errors))
    }

}