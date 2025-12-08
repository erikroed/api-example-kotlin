package org.example.userapi.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.example.userapi.model.User
import org.example.userapi.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

data class ErrorResponse(val error: String, val message: String)

@RestController
class UserController {

    val userService: UserService = UserService()

    @GetMapping("/users")
    @Operation(summary = "Get all users")
    @ApiResponse(responseCode = "200", description = "Get all users")
    fun getUsers(): List<User> {
        return userService.getUsers()
    }

    @GetMapping("/users/{id}")
    @Operation(summary = "Get user by id")
    @ApiResponses(
        value = [ApiResponse(responseCode = "200", description = "Get user by id"), ApiResponse(
            responseCode = "400",
            description = "Invalid request",
            content = [Content(schema = Schema(implementation = ErrorResponse::class))]
        ), ApiResponse(
            responseCode = "404",
            description = "User not found",
            content = [Content(schema = Schema(implementation = ErrorResponse::class))]
        )]
    )
    fun getUser(@Valid @NotNull @PathVariable id: Int): User {
        return userService.getUsers(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found")
    }

}