package com.aashushaikh.movie_backend.controller

import com.aashushaikh.movie_backend.security.AuthService
import jakarta.annotation.PostConstruct
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Pattern
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostConstruct
    fun init() {
        println("✅ AuthController loaded")
    }

    data class AuthRequest(
        @field:Email(message = "Invalid Email format")
        val email: String,
        @field:Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#\$%^&+=!]).{8,}\$",
            message = "Password should be 8 characters long and should include a upper case, lower case, special character and a digit."
        )
        val password: String
    )

    data class RefreshRequest(
        val refreshToken: String
    )

    @PostMapping("/register")
    fun register(
        @Valid @RequestBody body: AuthRequest
    ){
        authService.register(email = body.email, password = body.password)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody body: AuthRequest
    ): AuthService.TokenPair{
        return authService.login(email = body.email, password = body.password)
    }

}