package com.viona.projectojol.user.controller

import com.viona.projectojol.BaseResponse
import com.viona.projectojol.user.entity.UserLogin
import com.viona.projectojol.toResponses
import com.viona.projectojol.user.entity.LoginResponse
import com.viona.projectojol.user.service.UserService
import com.viona.projectojol.user.entity.User
import com.viona.projectojol.user.entity.UserRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUser(): BaseResponse<User> {
        val userId = SecurityContextHolder.getContext().authentication.principal as String
        return userService.getUserByUserId(userId).toResponses()
    }

    @PostMapping("/login")
    fun login(
        @RequestBody userLogin: UserLogin
    ): BaseResponse<LoginResponse> {
        return userService.login(userLogin).toResponses()
    }

    @PostMapping("/register")
    fun register(
        @RequestBody userRequest: UserRequest
    ): BaseResponse<Boolean> {
        return userService.register(userRequest.matToNewUser()).toResponses()
    }
}