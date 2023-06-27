package org.campusmolndal;

import java.util.ArrayList;
import java.util.List;

public class Todo {
    private int id;
    private String message;
    private boolean done;
    private String assignedTo;

    public Todo() {
        // Default constructor
    }

    public Todo(int id, String message, boolean done, String assignedTo) {
        this.id = id;
        this.message = message;
        this.done = done;
        this.assignedTo = assignedTo;
    }

    // Getters and setters

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
