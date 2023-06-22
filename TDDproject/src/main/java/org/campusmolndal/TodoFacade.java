package org.campusmolndal;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class TodoFacade {
    private DBFacade dbFacade;

    public TodoFacade() {
        dbFacade = new DBFacade();
    }

    public void createTodo(String message, boolean done, String assignedTo) {
        dbFacade.insertData(message, done, assignedTo);
    }

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        List<Document> documents = dbFacade.getAllData();

        // Iterera över varje dokument i listan av dokument
        for (Document document : documents) {
            int id = document.getInteger("id");
            String message = document.getString("todoMeddelande");
            boolean done = document.getBoolean("done");
            String assignedTo = document.getString("assignedTo");

            // Skapa ett nytt Todo-objekt och lägg till det i listan av Todos
            Todo todo = new Todo(id, message, done, assignedTo);
            todos.add(todo);
        }

        return todos;
    }

    public Todo getTodoById(int id) {
        Document document = dbFacade.getDataById(id);

        if (document != null) {
            int todoId = document.getInteger("id");
            String message = document.getString("todoMeddelande");
            boolean done = document.getBoolean("done");
            String assignedTo = document.getString("assignedTo");

            // Returnera ett nytt Todo-objekt baserat på dokumentet
            return new Todo(todoId, message, done, assignedTo);
        }

        return null;
    }

    public void updateTodo(Todo todo) {
        // Uppdatera en Todo genom att anropa metoden i DBFacade med de uppdaterade värdena
        dbFacade.updateData(todo.getId(), todo.getMessage(), todo.isDone(), todo.getAssignedTo());
    }

    public void deleteTodoById(int id) {
        // Ta bort en Todo baserat på dess id genom att anropa metoden i DBFacade
        dbFacade.deleteData(id);
    }

    public void closeConnection() {
        // Stäng anslutningen till databasen genom att anropa metoden i DBFacade
        dbFacade.closeConnection();
    }
}
