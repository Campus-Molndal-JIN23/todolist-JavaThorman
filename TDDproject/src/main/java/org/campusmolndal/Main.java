package org.campusmolndal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScannerInput input = new ScannerInput();
        TodoFacade todoFacade = new TodoFacade();
        todoFacade.createTodo(input.readStringTodo(), input.readBoolean(), input.readStringAssignee());
    }
}
