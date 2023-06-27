package org.campusmolndal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInput {
    private final Scanner input;

    public ScannerInput(Scanner scanner) {
        this.input = scanner;
    }

    /**
     * Reads an integer from the user.
     *
     * @param text The text to display when prompting the user for input.
     * @return The entered integer.
     */
    public int readInt(String text) {
        while (true) {
            try {
                System.out.print(text + ": ");
                int value = input.nextInt();
                input.nextLine();
                return value;
            } catch (InputMismatchException e) {
                input.nextLine(); // Clears invalid input from scanner
                System.out.println("Invalid value. Please enter an integer.");
            }
        }
    }

    /**
     * Reads a string from the user.
     *
     * @param text The text to display when prompting the user for input.
     * @return The entered string.
     */
    public String readString(String text) {
        System.out.print(text + " : ");
        String inputString = input.nextLine().trim();

        while (inputString.isEmpty()) {
            System.out.println("Field cannot be empty. Please enter text.");
            System.out.print(text + " : ");
            inputString = input.nextLine().trim();
        }

        return inputString;
    }

    /**
     * Reads a boolean value (true/false) from the user.
     *
     * @param text The text to display when prompting the user for input.
     * @return The entered boolean value.
     * @throws IllegalArgumentException if an invalid value is entered.
     */
    public boolean readBoolean(String text) {
        while (true) {
            System.out.print(text + " : ");
            String inputString = input.nextLine();

            if (inputString.equalsIgnoreCase("true")) {
                return true;
            } else if (inputString.equalsIgnoreCase("false")) {
                return false;
            } else {
                System.out.println("Invalid value. Please enter 'true' or 'false'.");
            }
        }
    }

    /**
     * Prints the output to the system console.
     *
     * @param output The output to be printed.
     */
    public void systemOutputs(String output) {
        System.out.println(output);
    }

    /**
     * Closes the scanner input and releases resources.
     */
    public void close() {
        input.close();
    }
}
