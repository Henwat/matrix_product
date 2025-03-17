import gridanalyzer.GridParser;
import gridanalyzer.GridProduct;
import gridanalyzer.GridSolver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Check with the provided example matrix
        Path gridPath = Paths.get("src/test/resources/test.txt");
        int kConsecutiveNumbers = 4;

        int[][] grid = GridParser.parse(gridPath);

        List<GridProduct> product = GridSolver.solve(grid, kConsecutiveNumbers);
        System.out.println("The largest product of the example matrix is:");
        product.forEach(System.out::println); //Product: 93168306

        //Solving the task
        Path gridPath2 = Paths.get("src/main/resources/grid.txt");
        int kConsecutiveNumbers2 = 4;
        int[][] grid2 = GridParser.parse(gridPath2);

        List<GridProduct> product2 = GridSolver.solve(grid2, kConsecutiveNumbers2);
        System.out.println("\nThe largest product of the puzzle-matrix is:");
        product2.forEach(System.out::println); //
    }
}
