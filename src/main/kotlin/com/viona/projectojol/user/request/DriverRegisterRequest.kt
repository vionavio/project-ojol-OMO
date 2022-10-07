package com.viona.projectojol.user.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.viona.projectojol.user.entity.User
import com.viona.projectojol.user.entity.extra.DriverExtras

data class DriverRegisterRequest(
    val username: String,
    val password: String,
    @JsonProperty("vehicles_number")
    val vehiclesNumber: String
) {
    fun mapToUser(): User {
        val userExtras = DriverExtras(vehiclesNumber)
        return User.createNewDriver(username, password, userExtras)
    }
}