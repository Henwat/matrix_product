package GridAnalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GridParser {

    private GridParser() {}

    public static int[][] parse(Path gridPath) {
        // Validation checks
        try {
            validateGrid(gridPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the dimensions. The matrix is assumed to be square.
        int dim = getGridDimensions(gridPath);

        int[][] grid = new int[dim][dim];

        //parse grid/matrix
        try(BufferedReader reader = Files.newBufferedReader(gridPath)) {
            String line;

            int index = 0;
            while( (line = reader.readLine()) != null) {
                int[] row = Stream.of(line.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                grid[index] = row;
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return grid;
    }

    private static void validateGrid(Path gridPath) throws IOException {
        if(Files.notExists(gridPath)) {
            throw new NoSuchFileException(gridPath.toString());
        }
        if(Files.size(gridPath) == 0) {
            throw new IllegalArgumentException("Grid file is empty");
        }
        if(!isSquare(gridPath)) {
            throw new IllegalArgumentException("Grid is not a square");
        }
    }

    private static boolean isSquare(Path path) throws IOException {
        List<String> grid = Files.readAllLines(path);

        if (grid.isEmpty()) return false;

        int rowDim = grid.size();
        int colDim = grid.getFirst().split("\\s+").length;

        //checks if the rows are equal size.
        for (String line : grid) {
            if (line.split("\\s+").length != colDim) return false;
        }
        return rowDim == colDim;
    }

    private static int getGridDimensions(Path path) {
        List<String> grid = new ArrayList<>();
        try {
            grid = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return grid.size();
    }
}
