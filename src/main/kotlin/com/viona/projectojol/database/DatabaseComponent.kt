package com.viona.projectojol.database

import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {

    //private val databaseUrl = System.getenv("DATABASE_URL")
    private val databaseUrl3 = "mongodb+srv://vionavio:666198@cluster0.fybrt.mongodb.net/?retryWrites=true&w=majority"
    val database: MongoClient = KMongo.createClient(databaseUrl3)
}