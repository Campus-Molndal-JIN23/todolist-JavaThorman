package org.campusmolndal;

import java.util.Scanner;

public class ScannerInput {
    private Scanner input;

    public ScannerInput() {
        input = new Scanner(System.in);
    }

    /**
     * Läser in ett heltal från användaren.
     * @return Det inmatade heltalet.
     */
    public int readInt() {
        System.out.print("Skriv in ett heltal: ");
        int value = input.nextInt();
        input.nextLine();
        return value;
    }

    /**
     * Läser in en text från användaren.
     * @return Den inmatade texten.
     */
    public String readStringTodo() {
        System.out.print("Skriv in en TODO text: ");
        return input.nextLine();
    }
    public String readStringAssignee() {
        System.out.print("Vem skall göra denna TODO?: ");
        return input.nextLine();
    }

    /**
     * Läser in en boolean (true/false) från användaren.
     * @return Det inmatade boolean-värdet.
     */
    public boolean readBoolean() {
        System.out.print("Är denna TODO färdig? (true / false): ");
        boolean value = input.nextBoolean();
        input.nextLine();
        return value;
    }

    /**
     * Stänger scanner-inputen och frigör resurser.
     */
    public void close() {
        input.close();
    }
}
