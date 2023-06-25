package org.campusmolndal;

import java.util.Scanner;

public class Program {
    private ScannerInput scannerInput;
    private TodoFacade todoFacade;

    public Program() {
        scannerInput = new ScannerInput(new Scanner(System.in));
        todoFacade = new TodoFacade();
    }

    public void start() {
        boolean running = true;

        while (running) {
            scannerInput.systemOutputs("==== Todo Program ====");
            scannerInput.systemOutputs("1. Create Todo");
            scannerInput.systemOutputs("2. View All Todos");
            scannerInput.systemOutputs("3. View Todo by ID");
            scannerInput.systemOutputs("4. Update Todo");
            scannerInput.systemOutputs("5. Delete Todo");
            scannerInput.systemOutputs("6. Exit");
            scannerInput.systemOutputs("\nEnter your choice");

            int choice = scannerInput.readInt("");

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
        todoFacade.closeConnection();
        scannerInput.close();
    }

    private void createTodo() {
        String message = scannerInput.readString("\nEnter the Todo message");
        boolean done = scannerInput.readBoolean("\nIs the Todo done? (true/false)");
        String assignedTo = scannerInput.readString("\nEnter the Todo assignee");

        todoFacade.createTodo(message, done, assignedTo);

        scannerInput.systemOutputs("\nTodo created successfully.\n");
    }

    private void viewAllTodos() {
        scannerInput.systemOutputs("\n==== All Todos ====\n");

        for (Todo todo : todoFacade.getAllTodos()) {
            // Print todo details
        }
    }

    private void viewTodoById() {
        int id = scannerInput.readInt("Enter the Todo ID\n");

        Todo todo = todoFacade.getTodoById(id);

        if (todo != null) {
            scannerInput.systemOutputs("==== Todo Details ====\n");
            scannerInput.systemOutputs("\nID: " + todo.getId());
            scannerInput.systemOutputs("\nMessage: " + todo.getMessage());
            scannerInput.systemOutputs("\nDone: " + todo.isDone());
            scannerInput.systemOutputs("\nAssigned To: " + todo.getAssignedTo());
        } else {
            scannerInput.systemOutputs("\nTodo not found.");
        }
    }

    private void updateTodo() {
        int id = scannerInput.readInt("\nEnter the Todo ID");

        Todo todo = todoFacade.getTodoById(id);

        if (todo != null) {
            scannerInput.systemOutputs("==== Update Todo ====");
            String message = scannerInput.readString("\nEnter the updated Todo message");
            boolean done = scannerInput.readBoolean("\nIs the Todo done? (true/false)");
            String assignedTo = scannerInput.readString("\nEnter the updated Todo assignee");

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
        int id = scannerInput.readInt("Enter the Todo ID");

        Todo todo = todoFacade.getTodoById(id);

        if (todo != null) {
            todoFacade.deleteTodoById(id);
            scannerInput.systemOutputs("Todo deleted successfully.");
        } else {
            scannerInput.systemOutputs("Todo not found");
        }
    }
}
