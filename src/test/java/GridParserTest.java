import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
class GridParserTest {


    @Test
    void testWithEmptyPath() {
        String gridURI = "";
        int numRows = 20;
        int numCols = 20;

        assertThrows(IOException.class, () -> {
            new GridParser(gridURI, numRows, numCols);
        });
    }




}