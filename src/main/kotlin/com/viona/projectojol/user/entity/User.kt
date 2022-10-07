package com.viona.projectojol.user.entity

import com.viona.projectojol.user.entity.extra.CustomerExtras
import com.viona.projectojol.user.entity.extra.DriverExtras
import com.viona.projectojol.user.entity.extra.Extras
import com.viona.projectojol.user.entity.extra.emptyExtra
import java.util.*

data class User(
    var id: String ="",
    var username: String = "",
    var password: String? = "",
    var role: Role = Role.CUSTOMER,
    var extra: Any = emptyExtra()
) {
    companion object {

        fun createNewDriver(username: String, password: String, extra: DriverExtras): User {
            return User(
                id = UUID.randomUUID().toString(),
                username = username,
                password = password,
                role = Role.DRIVER,
                extra = extra
            )
        }
        fun createNewUser(username: String, password: String): User {
            return User(
                id = UUID.randomUUID().toString(),
                username = username,
                password = password,
                role = Role.CUSTOMER
            )
        }
    }
}