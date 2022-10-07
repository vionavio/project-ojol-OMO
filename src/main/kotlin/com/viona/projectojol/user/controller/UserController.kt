package com.viona.projectojol.user.controller

import com.viona.projectojol.BaseResponse
import com.viona.projectojol.toResponses
import com.viona.projectojol.user.entity.LoginResponse
import com.viona.projectojol.user.entity.User
import com.viona.projectojol.user.entity.UserLogin
import com.viona.projectojol.user.request.CustomerRegisterRequest
import com.viona.projectojol.user.request.DriverRegisterRequest
import com.viona.projectojol.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @GetMapping
    fun getUser(): BaseResponse<User> {
        val userId = SecurityContextHolder.getContext().authentication.principal as? String
        return userService.getUserByUserId(userId.orEmpty()).toResponses()
    }

    @PostMapping("/login")
    fun login(
        @RequestBody userLogin: UserLogin
    ): BaseResponse<LoginResponse> {
        return userService.login(userLogin).toResponses()
    }

    @PostMapping("customer/register")
    fun register(
        @RequestBody userRequest: CustomerRegisterRequest
    ): BaseResponse<Boolean> {
        val user = userRequest.mapToUser()
        return userService.register(user).toResponses()
    }

    @PostMapping("/driver/register")
    fun registerDriver(
        @RequestBody userRequest: DriverRegisterRequest
    ): BaseResponse<Boolean>{
        val user = userRequest.mapToUser()
        return userService.register(user).toResponses()
    }
}