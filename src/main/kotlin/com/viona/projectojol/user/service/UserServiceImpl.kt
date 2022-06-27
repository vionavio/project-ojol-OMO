package com.viona.projectojol.user.service


import com.viona.projectojol.OjolException
import com.viona.projectojol.authentication.JwtConfig
import com.viona.projectojol.user.entity.LoginResponse
import com.viona.projectojol.user.entity.UserLogin
import com.viona.projectojol.user.repository.UserRepository
import com.viona.projectojol.user.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    @Autowired
    private val userRepository: UserRepository
) : UserService {
    override fun login(userLogin: UserLogin): Result<LoginResponse> {
        val resultUser = userRepository.getUserByUsername(userLogin.username)
        return resultUser.map {
            val token = JwtConfig.generateToken(it)
            val passwordInDb = it.password
            val passwordRequest = userLogin.password
            if (passwordInDb == passwordRequest) {
                LoginResponse(token)
            } else {
                throw OjolException("Password invalid")
            }
        }
    }

    override fun register(user: User): Result<Boolean> =
        userRepository.insertUser(user)

    override fun getUserByUserId(id: String): Result<User> {
        return userRepository.getUserById(id).map {
            it.password = null
            it
        }
    }

    override fun getUserByUsername(username: String): Result<User> {
        return userRepository.getUserByUsername(username).map {
            it.password = null
            it
        }
    }
}