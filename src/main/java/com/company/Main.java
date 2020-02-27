package com.company;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        MongoDatabase database = mongoClient.getDatabase("myMongoDB");

        MongoCollection<Document> collection = database.getCollection("bob");

        Document doc = new Document("name", "moikkel").append("language", "københasdfvnsk").append("alder", "456456").append("højde", "8777");

        collection.updateOne(eq("name", "mikkel"), new Document("$set", new Document("name", "karl")));
        //collection.insertOne(doc);

        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }


    }
}
