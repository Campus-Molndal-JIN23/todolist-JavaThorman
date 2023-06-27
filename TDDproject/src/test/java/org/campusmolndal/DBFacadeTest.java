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
        String todoMessage = "Sample Todo";
        boolean done = false;
        String assignedTo = "John Doe";

        // Call the insertData method in dbFacade
        dbFacade.insertData(todoMessage, done, assignedTo);

        // Verify that the insertData method in database is called once with the correct parameters
        verify(database, times(1)).insertData(todoMessage, done, assignedTo);
    }

    @Test
     void testGetAllData() {
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

        // Call the getAllData method in dbFacade and verify that it returns the expected data
        List<Document> actualData = dbFacade.getAllData();

        verify(database, times(1)).getAllData();
        assertEquals(expectedData, actualData);
    }

    @Test
     void testGetDataById() {
        int id = 1;
        Document expectedData = new Document("id", 1)
                .append("todoMessage", "Sample Todo")
                .append("done", false)
                .append("assignedTo", "John Doe");

        // Set up a mock response for getDataById method in database
        when(database.getDataById(id)).thenReturn(expectedData);

        // Call the getDataById method in dbFacade and verify that it returns the expected data
        Document actualData = dbFacade.getDataById(id);

        verify(database, times(1)).getDataById(id);
        assertEquals(expectedData, actualData);
    }

    @Test
     void testUpdateData() {
        int id = 1;
        String todoMessage = "Updated Todo";
        boolean done = true;
        String assignedTo = "Jane Smith";

        // Call the updateData method in dbFacade
        dbFacade.updateData(id, todoMessage, done, assignedTo);

        // Verify that the updateData method in database is called once with the correct parameters
        verify(database, times(1)).updateData(id, todoMessage, done, assignedTo);
    }

    @Test
     void testDeleteData() {
        int id = 1;

        // Call the deleteData method in dbFacade
        dbFacade.deleteData(id);

        // Verify that the deleteData method in database is called once with the correct parameter
        verify(database, times(1)).deleteData(id);
    }

    @Test
     void testCloseConnection() {
        // Call the closeConnection method in dbFacade
        dbFacade.closeConnection();

        // Verify that the closeConnection method in database is called once
        verify(database, times(1)).closeConnection();
    }
}
