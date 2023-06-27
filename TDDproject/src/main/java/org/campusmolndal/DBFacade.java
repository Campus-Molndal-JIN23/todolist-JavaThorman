package org.campusmolndal;

import org.bson.Document;

import java.util.List;

public class DBFacade {
    private Database database;

    public DBFacade(ScannerInput scannerInput) {
        // Initialize the Database instance and connect to the database
        database = new Database(scannerInput);
        database.connectToDatabase();
    }

    public void insertData(String todoMessage, boolean done, String assignedTo) {
        // Call the method to insert data into the database
        database.insertData(todoMessage, done, assignedTo);
    }

    public List<Document> getAllData() {
        // Retrieve all data from the database
        return database.getAllData();
    }

    public Document getDataById(int id) {
        // Retrieve data from the database based on the id
        return database.getDataById(id);
    }

    public void updateData(int id, String todoMessage, boolean done, String assignedTo) {
        // Update data in the database based on the id and the new values
        database.updateData(id, todoMessage, done, assignedTo);
    }

    public void deleteData(int id) {
        // Delete data from the database based on the id
        database.deleteData(id);
    }

    public void closeConnection() {
        // Close the connection to the database
        database.closeConnection();
    }
}
