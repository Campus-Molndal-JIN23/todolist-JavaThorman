package org.campusmolndal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    private Todo sut;

    @BeforeEach
    public void setUp() {
        sut = new Todo(1, "Title", false, "JONAS");
    }

    @Test
    public void testGetId() {
        // Arrange
        int expectedId = 1;

        // Act
        int actualId = sut.getId();

        // Assert
        assertEquals(expectedId, actualId);
    }

    @Test
    public void testSetId() {
        // Arrange
        int newId = 5;

        // Act
        sut.setId(newId);

        // Assert
        assertEquals(newId, sut.getId());
    }

    @Test
    public void testGetMessage() {
        // Arrange
        String expectedMessage = "Title";

        // Act
        String actualMessage = sut.getMessage();

        // Assert
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testSetMessage() {
        // Arrange
        String newMessage = "New Title";

        // Act
        sut.setMessage(newMessage);

        // Assert
        assertEquals(newMessage, sut.getMessage());
    }

    @Test
    public void testIsDone() {
        // Arrange
        boolean expectedDone = false;

        // Act
        boolean actualDone = sut.isDone();

        // Assert
        assertEquals(expectedDone, actualDone);
    }

    @Test
    public void testSetDone() {
        // Arrange
        boolean newDone = true;

        // Act
        sut.setDone(newDone);

        // Assert
        assertEquals(newDone, sut.isDone());
    }

    @Test
    public void testGetAssignedTo() {
        // Arrange
        String expectedAssignedTo = "JONAS";

        // Act
        String actualAssignedTo = sut.getAssignedTo();

        // Assert
        assertEquals(expectedAssignedTo, actualAssignedTo);
    }

    @Test
    public void testSetAssignedTo() {
        // Arrange
        String newAssignedTo = "JOHAN";

        // Act
        sut.setAssignedTo(newAssignedTo);

        // Assert
        assertEquals(newAssignedTo, sut.getAssignedTo());
    }
}
