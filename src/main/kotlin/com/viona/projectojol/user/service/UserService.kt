package com.viona.projectojol.user.service

import com.viona.projectojol.user.entity.LoginResponse
import com.viona.projectojol.user.entity.UserLogin
import com.viona.projectojol.user.entity.User

interface UserService {
    fun login(userLogin: UserLogin): Result<LoginResponse>
    fun register(user: User): Result<Boolean>
    fun getUserByUserId(id: String): Result<User>
    fun getUserByUsername(username: String): Result<User>

}