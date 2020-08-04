package utils

import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import org.bson.Document

object MongoConnector {

    @JvmStatic
    fun connectDB (): MongoDatabase {
        var mongoClient: MongoClient? = null
        mongoClient = MongoClient("127.0.0.1", 27017)
        val db = mongoClient.getDatabase("Oikotie")
        return db
    }

    fun responseTime(time: Long?, endpoint: String?) {
        val db = connectDB()
        val tbl = db.getCollection("mobileApiPerformance")

        val datetime = Configuration.datetime
        val document = Document()
        document["endpoint"] = endpoint
        document["responseTime"] = time
        document["dateTime"] = datetime
        tbl.insertOne(document)
    }
}