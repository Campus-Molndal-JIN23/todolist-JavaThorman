package org.campusmolndal;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Indexes.descending;

public class Database {
    private com.mongodb.client.MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public void connectToDatabase() {
        String uri = "mongodb://localhost:27017/TodoDB";

        // Konfigurera MongoClientSettings med anslutnings-URI:en
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new com.mongodb.ConnectionString(uri))
                .build();

        // Skapa en MongoClient med MongoClientSettings
        mongoClient = MongoClients.create(settings);

        // Hämta en referens till databasen
        database = mongoClient.getDatabase("TodoDB");

        // Hämta en referens till samlingen
        collection = database.getCollection("todos");

        System.out.println("Du är ansluten!");
    }

    public void insertData(String todoMeddelande, boolean done, String assignedTo) {
        // Skapa ett nytt dokument med datan
        Document document = new Document();
        document.append("id", getNextId());
        document.append("todoMeddelande", todoMeddelande);
        document.append("done", done);
        document.append("assignedTo", assignedTo);

        // Infoga dokumentet i samlingen
        collection.insertOne(document);

        System.out.println("Todo skapades framgångsrikt!");
    }

    private int getNextId() {
        // Hitta det högsta ID:t i databasen och öka det med 1
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

        for (Document document : documents) {
            int id = document.getInteger("id");
            String todoMeddelande = document.getString("todoMeddelande");
            boolean done = document.getBoolean("done");
            String assignedTo = document.getString("assignedTo");

            System.out.println("ID: " + id);
            System.out.println("Todo meddelande: " + todoMeddelande);
            System.out.println("Klart: " + done);
            System.out.println("Tilldelad till: " + assignedTo);
            System.out.println("------------------------------------");
        }
        return documents;
    }


    public Document getDataById(int id) {
        // Hämta ett dokument baserat på dess ID
        Bson filter = eq("id", id);
        return collection.find(filter).first();
    }

    public void updateData(int id, String todoMeddelande, boolean done, String assignedTo) {
        // Skapa ett filter för dokumentet som ska uppdateras
        Bson filter = eq("id", id);

        // Skapa en uppdatering med de nya värdena
        Bson update = new Document("$set", new Document()
                .append("todoMeddelande", todoMeddelande)
                .append("done", done)
                .append("assignedTo", assignedTo));

        // Uppdatera dokumentet i samlingen
        collection.updateOne(filter, update);

        System.out.println("Todo uppdaterades framgångsrikt!");
    }

    public void deleteData(int id) {
        // Skapa ett filter för dokumentet som ska tas bort
        Bson filter = eq("id", id);

        // Ta bort dokumentet från samlingen
        collection.deleteOne(filter);

        System.out.println("Todo raderades framgångsrikt!");
    }

    public void closeConnection() {
        System.out.println("Anslutning stängd.");

        // Stäng anslutningen när du är klar
        mongoClient.close();
    }
}
