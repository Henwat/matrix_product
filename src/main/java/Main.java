import java.util.List;

public class Main {
    public static void main(String[] args) {
        String gridURI = "src/main/resources/grid.txt";
        GridParser gridParser = new GridParser(gridURI, 20, 20);
        int[][] grid = gridParser.gridParser();

        GridSolver gridSolver = new GridSolver(4, grid);
        List<GridProduct> gridProduct = gridSolver.solve();
        System.out.println(gridProduct);
    }

}
