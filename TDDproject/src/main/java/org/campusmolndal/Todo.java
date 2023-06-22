package org.campusmolndal;

public class Todo {
    private int id;
    private String message;
    private boolean done;
    private String assignedTo;

    public Todo() {
        // Tom konstruktor för att tillåta instansiering utan parametrar
    }

    public Todo(int id, String message, boolean done, String assignedTo) {
        this.id = id;
        this.message = message;
        this.done = done;
        this.assignedTo = assignedTo;
    }

    // Getter- och setter-metoder för alla attribut

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
}
