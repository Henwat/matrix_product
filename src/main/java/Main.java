import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path gridPath = Paths.get("src/test/resources/test.txt");
        int nConsecutiveNumbers = 4;

        int[][] grid = GridParser.parse(gridPath);

        List<GridProduct> product = GridSolver.solve(grid, nConsecutiveNumbers);
        for (GridProduct p : product) {
            System.out.println(p);
        }
    }
}
