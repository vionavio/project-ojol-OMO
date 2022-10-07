package com.viona.projectojol.user.request

import com.viona.projectojol.user.entity.User

data class CustomerRegisterRequest(
    val username: String,
    val password: String
) {
    fun mapToUser(): User {
        return User.createNewUser(username, password)
    }
}