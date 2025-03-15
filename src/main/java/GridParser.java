import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GridParser {
    private final String gridURI;
    private final int numRows;
    private final int numCols;

    public GridParser(String puzzleURI, int numRows, int numCols) {
        this.gridURI = puzzleURI;
        this.numRows = numRows;
        this.numCols = numCols;
    }


    public long[][] gridParser() {
        Path path = Paths.get(gridURI);
        long[][] grid = new long[numRows][numCols]; //Use long to account for large products

        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            int index = 0;
            while( (line = reader.readLine()) != null) {
                long[] row = Stream.of(line.split(" "))
                        .mapToLong(Long::parseLong)
                        .toArray();
                grid[index] = row;
                index++;
            }
        } catch (NoSuchFileException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return grid;
    }
}
