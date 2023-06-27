package org.campusmolndal;

import java.util.Scanner;

public class Program {
    private ScannerInput scannerInput;
    private TodoFacade todoFacade;

    private Database database;

    public Program() {
        scannerInput = new ScannerInput(new Scanner(System.in));
        database = new Database(); // Initialize the Database instance
        todoFacade = new TodoFacade(scannerInput, database);
    }

    public void start() {
        boolean running = true;

        while (running) {
            scannerInput.systemOutputs("==== Todo Program ====");
            // Display menu options
            scannerInput.systemOutputs("1. Create Todo");
            scannerInput.systemOutputs("2. View All Todos");
            scannerInput.systemOutputs("3. View Todo by ID");
            scannerInput.systemOutputs("4. Update Todo");
            scannerInput.systemOutputs("5. Delete Todo");
            scannerInput.systemOutputs("6. Exit");
            scannerInput.systemOutputs("\nEnter your choice");

            // Read user's choice
            int choice = scannerInput.readInt("");

            // Execute corresponding action based on the choice
            switch (choice) {
                case 1:
                    createTodo();
                    break;
                case 2:
                    viewAllTodos();
                    break;
                case 3:
                    viewTodoById();
                    break;
                case 4:
                    updateTodo();
                    break;
                case 5:
                    deleteTodo();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    scannerInput.systemOutputs("\nInvalid choice. Please try again.");
            }
        }
    }

    public void stop() {
        // Close the database connection and the scanner
        todoFacade.closeConnection();
        scannerInput.close();
    }

    private void createTodo() {
        // Prompt user for Todo details
        String message = scannerInput.readString("\nEnter the Todo message");
        boolean done = scannerInput.readBoolean("\nIs the Todo done? (true/false)");
        String assignedTo = scannerInput.readString("\nEnter the Todo assignee");

        // Create a Todo using the facade
        todoFacade.createTodo(message, done, assignedTo);

        scannerInput.systemOutputs("\nTodo created successfully.\n");
    }

    private void viewAllTodos() {
        scannerInput.systemOutputs("\n==== All Todos ====\n");

        // Retrieve all Todos from the facade and print their details
        for (Todo todo : todoFacade.getAllTodos()) {
            // Print todo details
            scannerInput.systemOutputs("\nID: " + todo.getId());
            scannerInput.systemOutputs("Message: " + todo.getMessage());
            scannerInput.systemOutputs("Done: " + todo.isDone());
            scannerInput.systemOutputs("Assigned To: " + todo.getAssignedTo());
        }
    }

    private void viewTodoById() {
        // Prompt user for the Todo ID
        int id = scannerInput.readInt("Enter the Todo ID\n");

        // Retrieve the Todo by ID from the facade
        Todo todo = todoFacade.getTodoById(id);

        if (todo != null) {
            scannerInput.systemOutputs("==== Todo Details ====\n");
            // Print the details of the Todo
            scannerInput.systemOutputs("\nID: " + todo.getId());
            scannerInput.systemOutputs("Message: " + todo.getMessage());
            scannerInput.systemOutputs("Done: " + todo.isDone());
            scannerInput.systemOutputs("Assigned To: " + todo.getAssignedTo());
        } else {
            scannerInput.systemOutputs("\nTodo not found.");
        }
    }

    private void updateTodo() {
        // Prompt user for the Todo ID to update
        int id = scannerInput.readInt("\nEnter the Todo ID");

        // Retrieve the Todo by ID from the facade
        Todo todo = todoFacade.getTodoById(id);

        if (todo != null) {
            scannerInput.systemOutputs("==== Update Todo ====");
            // Prompt user for the updated Todo details
            String message = scannerInput.readString("\nEnter the updated Todo message");
            boolean done = scannerInput.readBoolean("\nIs the Todo done? (true/false)");
            String assignedTo = scannerInput.readString("\nEnter the updated Todo assignee");

            // Update the Todo using the facade
            todo.setMessage(message);
            todo.setDone(done);
            todo.setAssignedTo(assignedTo);

            todoFacade.updateTodo(todo);

            scannerInput.systemOutputs("\nTodo updated successfully.\n");
        } else {
            scannerInput.systemOutputs("Todo not found");
        }
    }

    private void deleteTodo() {
        // Prompt user for the Todo ID to delete
        int id = scannerInput.readInt("Enter the Todo ID");

        // Retrieve the Todo by ID from the facade
        Todo todo = todoFacade.getTodoById(id);

        if (todo != null) {
            // Delete the Todo by ID using the facade
            todoFacade.deleteTodoById(id);
            scannerInput.systemOutputs("Todo deleted successfully.");
        } else {
            scannerInput.systemOutputs("Todo not found");
        }
    }
}
