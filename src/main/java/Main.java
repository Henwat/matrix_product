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
        System.out.println("\nThe largest product of the example matrix is:");
        product.forEach(System.out::println); //Product: 93168306

        //Test Case 2
        Path gridPath2 = Paths.get("src/test/resources/test2.txt");
        int kConsecutiveNumbers2 = 4;
        int[][] grid2 = GridParser.parse(gridPath2);

        List<GridProduct> product2 = GridSolver.solve(grid2, kConsecutiveNumbers2);
        System.out.println("\nThe largest product of the example matrix is:");
        product2.forEach(System.out::println);

        //Test Case 3
        Path gridPath3 = Paths.get("src/test/resources/test3.txt");
        int kConsecutiveNumbers3 = 4;
        int[][] grid3 = GridParser.parse(gridPath3);

        List<GridProduct> product3 = GridSolver.solve(grid3, kConsecutiveNumbers3);
        System.out.println("\nThe largest product of the example matrix is:");
        product3.forEach(System.out::println);


        //Solving the task
        Path gridPath4 = Paths.get("src/main/resources/grid.txt");
        int kConsecutiveNumbers4 = 4;
        int[][] grid4 = GridParser.parse(gridPath4);

        List<GridProduct> product4 = GridSolver.solve(grid4, kConsecutiveNumbers4);
        System.out.println("\nThe largest product of the puzzle-matrix is:");
        product4.forEach(System.out::println); //
    }
}
