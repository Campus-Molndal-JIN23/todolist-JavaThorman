package org.campusmolndal;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TodoFacade {
    private Database database;
    private DBFacade dbFacade;

    public TodoFacade(ScannerInput scannerInput, Database database) {
        // Initialize the DBFacade instance with the ScannerInput
        this.database = database;
        dbFacade = new DBFacade(database);
    }

    public void createTodo(String message, boolean done, String assignedTo) {
        // Call the method in DBFacade to create a new Todo
        dbFacade.insertData(message, done, assignedTo);
    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        List<Document> documents = dbFacade.getAllData();

        // Iterate over each document in the list of documents
        for (Document document : documents) {
            int id = document.getInteger("id");
            String message = document.getString("todoMessage");
            boolean done = document.getBoolean("done");
            String assignedTo = document.getString("assignedTo");

            // Create a new Todo object and add it to the list of Todos
            Todo todo = new Todo(id, message, done, assignedTo);
            todos.add(todo);
        }

        return todos;
    }

    public Todo getTodoById(int id) {
        Document document = dbFacade.getDataById(id);

        if (document != null) {
            int todoId = document.getInteger("id");
            String message = document.getString("todoMessage");
            boolean done = document.getBoolean("done");
            String assignedTo = document.getString("assignedTo");

            // Return a new Todo object based on the document
            return new Todo(todoId, message, done, assignedTo);
        }

        return null;
    }

    public void updateTodo(Todo todo) {
        // Update a Todo by calling the method in DBFacade with the updated values
        dbFacade.updateData(todo.getId(), todo.getMessage(), todo.isDone(), todo.getAssignedTo());
    }

    public void deleteTodoById(int id) {
        // Delete a Todo based on its id by calling the method in DBFacade
        dbFacade.deleteData(id);
    }

    public void closeConnection() {
        // Close the connection to the database by calling the method in DBFacade
        dbFacade.closeConnection();
    }
}