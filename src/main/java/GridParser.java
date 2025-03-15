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


    public int[][] gridParser() {
        Path path = Paths.get(gridURI);
        int[][] grid = new int[numRows][numCols];

        try(BufferedReader reader = Files.newBufferedReader(path)) {
            String line;

            int index = 0;
            while( (line = reader.readLine()) != null) {
                int[] row = Stream.of(line.split(" "))
                        .mapToInt(Integer::parseInt)
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
