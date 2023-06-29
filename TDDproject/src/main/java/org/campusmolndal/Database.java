package org.campusmolndal;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.descending;

public class Database {
    private com.mongodb.client.MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private ScannerInput input;

    public Database() {
        input = new ScannerInput(new Scanner(System.in));
        connectToDatabase();
    }


    public void connectToDatabase() {
        String uri = "mongodb://localhost:27017/TodoDB";

        // Configure MongoClientSettings with the connection URI
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new com.mongodb.ConnectionString(uri))
                .build();

        // Create a MongoClient with MongoClientSettings
        mongoClient = MongoClients.create(settings);

        // Get a reference to the database
        database = mongoClient.getDatabase("TodoDB");

        // Get a reference to the collection
        collection = database.getCollection("todos");
    }

    public void insertData(String todoMessage, boolean done, String assignedTo) {
        // Create a new document with the data
        Document document = new Document();
        document.append("id", getNextId());
        document.append("todoMessage", todoMessage);
        document.append("done", done);
        document.append("assignedTo", assignedTo);

        // Insert the document into the collection
        collection.insertOne(document);
    }

    private int getNextId() {
        // Find the highest ID in the database and increment it by 1
        Bson sort = descending("id");
        Document highestIdDocument = collection.find().sort(sort).limit(1).first();
        int highestId = 0;
        if (highestIdDocument != null) {
            highestId = highestIdDocument.getInteger("id", 0);
        }
        return highestId + 1;
    }

    public List<Document> getAllData() {
        List<Document> documents = collection.find().into(new ArrayList<>());
        return documents;
    }


    public Document getDataById(int id) {
        // Retrieve a document based on its ID
        Bson filter = eq("id", id);
        return collection.find(filter).first();
    }

    public void updateData(int id, String todoMessage, boolean done, String assignedTo) {
        // Create a filter for the document to be updated
        Bson filter = eq("id", id);

        // Create an update with the new values
        Bson update = new Document("$set", new Document()
                .append("todoMessage", todoMessage)
                .append("done", done)
                .append("assignedTo", assignedTo));

        // Update the document in the collection
        collection.updateOne(filter, update);
    }

    public void deleteData(int id) {
        // Create a filter for the document to be deleted
        Bson filter = eq("id", id);

        // Delete the document from the collection
        collection.deleteOne(filter);

        input.systemOutputs("Todo successfully deleted!");
    }

    public void closeConnection() {
        input.systemOutputs("Connection closed.");

        // Close the connection when finished
        mongoClient.close();
    }
}
