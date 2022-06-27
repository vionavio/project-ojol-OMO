package com.viona.projectojol.user.repository

import com.viona.projectojol.user.entity.User

interface UserRepository {

    fun insertUser(user: User): Result<Boolean>

    fun getUserById(id: String): Result<User>

    fun getUserByUsername(username: String): Result<User>
}