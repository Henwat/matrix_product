import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class GridSolverTest {

    @Test
    void testResults() {
        int[][] mockGrid = {
                {0, 0, 0, 9},
                {0, 0, 8, 0},
                {0, 1, 0, 0},
                {1, 0, 0, 0}
        };

        GridProduct expected = new GridProduct(72, new int[][]{{0,3},{1,2},{2,1},{3,1}}, new int[]{9,8,1,1});
        List<GridProduct> expectedList = new ArrayList<>(List.of(expected));

        GridSolver gridSolver = new GridSolver(4, mockGrid);
        List<GridProduct> result = gridSolver.solve();

        assertEquals(expectedList, result, "The GridProducts should be equal");
    }
}