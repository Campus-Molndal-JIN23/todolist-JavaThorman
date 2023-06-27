package org.campusmolndal;

public class Todo {
    private int id;
    private String message;
    private boolean done;
    private String assignedTo;

    public Todo() {
        // Empty constructor to allow instantiation without parameters
    }

    public Todo(int id, String message, boolean done, String assignedTo) {
        this.id = id;
        this.message = message;
        this.done = done;
        this.assignedTo = assignedTo;
    }

    // Getter and setter methods for all attributes

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
