package org.campusmolndal;
import java.util.*;

public class ScannerInput {
    private final Scanner input;

    public ScannerInput(Scanner scanner) {
        this.input = scanner;
    }

    /**
     * Läser in ett heltal från användaren.
     * @param text Texten som ska visas för att be användaren om inmatning.
     * @return Det inmatade heltalet.
     */
    public int readInt(String text) {
        while (true) {
            try {
                System.out.print(text + " : ");
                int value = input.nextInt();
                input.nextLine();
                return value;
            } catch (InputMismatchException e) {
                input.nextLine(); // Rensar bort ogiltig inmatning från scanner
                System.out.println("Ogiltigt värde. Var god ange ett heltal.");
            }
        }
    }

    /**
     * Läser in en text från användaren.
     * @param text Texten som ska visas för att be användaren om inmatning.
     * @return Den inmatade texten.
     */
    public String readString(String text) {
        System.out.print(text + " : ");
        String inputString = input.nextLine().trim();

        while (inputString.isEmpty()) {
            System.out.println("Fältet får inte vara tomt. Var god ange en text.");
            System.out.print(text + " : ");
            inputString = input.nextLine().trim();
        }

        return inputString;
    }

    /**
     * Läser in en boolean (true/false) från användaren.
     * @param text Texten som ska visas för att be användaren om inmatning.
     * @return Det inmatade boolean-värdet.
     * @throws IllegalArgumentException om ogiltigt värde matas in.
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
     * Stänger scanner-inputen och frigör resurser.
     */
    public void close() {
        input.close();
    }
}
