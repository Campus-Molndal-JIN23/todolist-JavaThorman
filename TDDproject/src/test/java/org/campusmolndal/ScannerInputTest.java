package org.campusmolndal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ScannerInputTest {

    @Mock
    private Scanner mockScanner;

    private ScannerInput input;
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        input = new ScannerInput(mockScanner);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        input.close();
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    void testReadIntValidInput() {
        // Arrange
        int expected = 42;
        when(mockScanner.nextInt()).thenReturn(expected);
        when(mockScanner.nextLine()).thenReturn(""); // Simulate clearing the input

        // Act
        int actual = input.readInt("");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testReadIntInvalidInputThenValidInput() {
        // Arrange
        String invalidInput = "abc";
        int validInput = 42;
        when(mockScanner.nextInt())
                .thenThrow(new InputMismatchException()) // Throw exception for the first input
                .thenReturn(validInput); // Return valid input for the second input
        when(mockScanner.nextLine()).thenReturn(invalidInput, ""); // Simulate input lines

        // Act
        int actual = input.readInt("");

        // Assert
        assertEquals(validInput, actual);
    }

    @Test
    void testReadStringValidInput() {
        // Arrange
        String expected = "Hello";
        when(mockScanner.nextLine()).thenReturn(expected);

        // Act
        String actual = input.readString("");

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void testReadStringEmptyInputThenValidInput() {
        // Arrange
        String emptyInput = "";
        String validInput = "Hello";
        when(mockScanner.nextLine()).thenReturn(emptyInput, validInput);

        // Act
        String actual = input.readString("");

        // Assert
        assertEquals(validInput, actual);
    }
}
