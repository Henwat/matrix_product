import GridAnalyzer.GridParser;
import GridAnalyzer.GridProduct;
import GridAnalyzer.GridSolver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path gridPath = Paths.get("src/test/resources/test3.txt");
        int kConsecutiveNumbers = 4;

        int[][] grid = GridParser.parse(gridPath);

        List<GridProduct> product = GridSolver.solve(grid, kConsecutiveNumbers);
        for (GridProduct p : product) {
            System.out.println(p);
        }
    }
}
