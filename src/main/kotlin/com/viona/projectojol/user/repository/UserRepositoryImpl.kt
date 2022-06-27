package com.viona.projectojol.user.repository

import com.mongodb.client.MongoCollection
import com.viona.projectojol.OjolException
import com.viona.projectojol.database.DatabaseComponent
import com.viona.projectojol.toResult
import com.viona.projectojol.user.entity.User
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    @Autowired
    private val databaseComponent: DatabaseComponent
) : UserRepository {

    private fun getCollection(): MongoCollection<User> =
        databaseComponent.database.getDatabase("ojol_omo").getCollection()

    override fun insertUser(user: User): Result<Boolean> {
        val existingUser = getUserByUsername(user.username)
        return if (existingUser.isSuccess) {
            throw OjolException("user exist!")
        } else getCollection().insertOne(user).wasAcknowledged().toResult()
    }

    override fun getUserById(id: String): Result<User> =
        getCollection().findOne(User::id eq id).toResult()

    override fun getUserByUsername(username: String): Result<User> =
        getCollection().findOne(User::username eq username).toResult()

}