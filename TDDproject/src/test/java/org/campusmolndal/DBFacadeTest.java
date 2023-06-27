package org.campusmolndal;

import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DBFacadeTest {
    @Mock
    private Database database;

    private DBFacade dbFacade;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        dbFacade = new DBFacade(database);
    }

    @Test
    void testInsertData() {
        // Arrange
        String todoMessage = "Sample Todo";
        boolean done = false;
        String assignedTo = "John Doe";

        // Act
        dbFacade.insertData(todoMessage, done, assignedTo);

        // Assert
        // Verify that the insertData method in database is called once with the correct parameters
        verify(database, times(1)).insertData(todoMessage, done, assignedTo);
    }

    @Test
    void testGetAllData() {
        // Arrange
        List<Document> expectedData = new ArrayList<>();
        expectedData.add(new Document("id", 1)
                .append("todoMessage", "Todo 1")
                .append("done", false)
                .append("assignedTo", "John Doe"));
        expectedData.add(new Document("id", 2)
                .append("todoMessage", "Todo 2")
                .append("done", true)
                .append("assignedTo", "Jane Smith"));

        // Set up a mock response for getAllData method in database
        when(database.getAllData()).thenReturn(expectedData);

        // Act
        List<Document> actualData = dbFacade.getAllData();

        // Assert
        // Verify that the getAllData method in database is called once
        verify(database, times(1)).getAllData();
        // Verify that the returned data matches the expected data
        assertEquals(expectedData, actualData);
    }

    @Test
    void testGetDataById() {
        // Arrange
        int id = 1;
        Document expectedData = new Document("id", 1)
                .append("todoMessage", "Sample Todo")
                .append("done", false)
                .append("assignedTo", "John Doe");

        // Set up a mock response for getDataById method in database
        when(database.getDataById(id)).thenReturn(expectedData);

        // Act
        Document actualData = dbFacade.getDataById(id);

        // Assert
        // Verify that the getDataById method in database is called once with the correct parameter
        verify(database, times(1)).getDataById(id);
        // Verify that the returned data matches the expected data
        assertEquals(expectedData, actualData);
    }

    @Test
    void testUpdateData() {
        // Arrange
        int id = 1;
        String todoMessage = "Updated Todo";
        boolean done = true;
        String assignedTo = "Jane Smith";

        // Act
        dbFacade.updateData(id, todoMessage, done, assignedTo);

        // Assert
        // Verify that the updateData method in database is called once with the correct parameters
        verify(database, times(1)).updateData(id, todoMessage, done, assignedTo);
    }

    @Test
    void testDeleteData() {
        // Arrange
        int id = 1;

        // Act
        dbFacade.deleteData(id);

        // Assert
        // Verify that the deleteData method in database is called once with the correct parameter
        verify(database, times(1)).deleteData(id);
    }

    @Test
    void testCloseConnection() {
        // Act
        dbFacade.closeConnection();

        // Assert
        // Verify that the closeConnection method in database is called once
        verify(database, times(1)).closeConnection();
    }
}
