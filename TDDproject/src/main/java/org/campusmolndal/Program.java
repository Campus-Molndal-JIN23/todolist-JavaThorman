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
            System.out.println("==== Todo Program ====");
            System.out.println("1. Create Todo");
            System.out.println("2. View All Todos");
            System.out.println("3. View Todo by ID");
            System.out.println("4. Update Todo");
            System.out.println("5. Delete Todo");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice");

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
                    System.out.println("\nInvalid choice. Please try again.");
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

        System.out.println("\nTodo created successfully.\n");
    }

    private void viewAllTodos() {
        System.out.println("\n==== All Todos ====\n");

        for (Todo todo : todoFacade.getAllTodos()) {

        }
    }

    private void viewTodoById() {
        int id = scannerInput.readInt("Enter the Todo ID\n");

        Todo todo = todoFacade.getTodoById(id);

        if (todo != null) {
            System.out.println("==== Todo Details ====\n");
            System.out.println("\nID: " + todo.getId());
            System.out.println("\nMessage: " + todo.getMessage());
            System.out.println("\nDone: " + todo.isDone());
            System.out.println("\nAssigned To: " + todo.getAssignedTo());
        } else {
            System.out.println("\nTodo not found.");
        }
    }

    private void updateTodo() {
        int id = scannerInput.readInt("\nEnter the Todo ID");

        Todo todo = todoFacade.getTodoById(id);

        if (todo != null) {
            System.out.println("==== Update Todo ====");
            String message = scannerInput.readString("\nEnter the updated Todo message");
            boolean done = scannerInput.readBoolean("\nIs the Todo done? (true/false)");
            String assignedTo = scannerInput.readString("\nEnter the updated Todo assignee");

            todo.setMessage(message);
            todo.setDone(done);
            todo.setAssignedTo(assignedTo);

            todoFacade.updateTodo(todo);

            System.out.println("\nTodo updated successfully.\n");
        } else {
            System.out.println("Todo not found.");
        }
    }

    private void deleteTodo() {
        int id = scannerInput.readInt("Enter the Todo ID");

        Todo todo = todoFacade.getTodoById(id);

        if (todo != null) {
            todoFacade.deleteTodoById(id);
            System.out.println("Todo deleted successfully.");
        } else {
            System.out.println("Todo not found.");
        }
    }

}
