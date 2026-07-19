package com.aita.config;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoConfig {
    private static final String URI = ConfigManager.get("MONGO_URI");
    private static final String DB_NAME = ConfigManager.get("MONGO_DATABASE_NAME");

    public static MongoDatabase getDatabase() {
        MongoClient mongoClient = MongoClients.create(URI);
        return mongoClient.getDatabase(DB_NAME);
    }

    public static void insertTestRun(int runId, String status) {
        MongoDatabase db = getDatabase();
        MongoCollection<Document> collection = db.getCollection("test_runs");
        collection.insertOne(new Document("run_id", runId).append("status", status));
    }
}
