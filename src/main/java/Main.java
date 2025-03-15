import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String gridURI = "src/main/resources/test2.txt";
        GridParser gridParser = new GridParser(gridURI, 20, 20);
        long[][] grid = gridParser.gridParser();

        //for(long[] row : grid) System.out.println(Arrays.toString(row));

        GridSolver gridSolver = new GridSolver(4, grid);
        long solution = gridSolver.solve();
        System.out.println(solution);

    }

}
