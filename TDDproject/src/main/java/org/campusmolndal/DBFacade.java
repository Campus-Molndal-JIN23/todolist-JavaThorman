package org.campusmolndal;

import org.bson.Document;

import java.util.List;

public class DBFacade {
    private Database database;

    public DBFacade() {
        database = new Database();
        database.connectToDatabase();
    }

    public void insertData(String todoMeddelande, boolean done, String assignedTo) {
        // Anropa metoden för att infoga data i databasen
        database.insertData(todoMeddelande, done, assignedTo);
    }

    public List<Document> getAllData() {
        // Hämta alla data från databasen
        return database.getAllData();
    }

    public Document getDataById(int id) {
        // Hämta data från databasen baserat på id
        return database.getDataById(id);
    }

    public void updateData(int id, String todoMeddelande, boolean done, String assignedTo) {
        // Uppdatera data i databasen baserat på id och de nya värdena
        database.updateData(id, todoMeddelande, done, assignedTo);
    }

    public void deleteData(int id) {
        // Ta bort data från databasen baserat på id
        database.deleteData(id);
    }

    public void closeConnection() {
        // Stäng anslutningen till databasen
        database.closeConnection();
    }
}
