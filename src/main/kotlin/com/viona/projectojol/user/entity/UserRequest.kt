package com.viona.projectojol.user.entity

data class UserRequest(
    val username: String,
    val password: String
){
    fun matToNewUser(): User {
        return User.createNewUser(username, password)
    }
}