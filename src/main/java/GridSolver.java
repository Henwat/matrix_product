

import java.util.ArrayList;
import java.util.List;

public class GridSolver {
    int nConsecutive;
    int[][] grid;

    public GridSolver(int nConsecutive, int[][] grid) {
        if(!isSquare(grid)) {
            throw new IllegalArgumentException("Grid must be square");
        }
        if(!consecutiveNumbersLessOrEqualDim(grid, nConsecutive)) {
            throw new IllegalArgumentException("Consecutive numbers must not surpass the dimensions of the matrix");
        }

        this.nConsecutive = nConsecutive;
        this.grid = grid;
    }

    public List<GridProduct> solve() {
        int rowDim = grid.length;
        int colDim = grid[0].length;
        long maxProd = 0;

        List<GridProduct> maxProducts = new ArrayList<>();

        for (int row = 0; row < rowDim; row++) {
            for (int col = 0; col < colDim; col++) {

                //Horizontal product of numConsecutive numbers
                if (col + nConsecutive - 1 < colDim) {
                    long currentProd = 1;
                    int[][] coordinates = new int[nConsecutive][2];
                    int[] factors = new int[nConsecutive];

                    for (int i = 0; i < nConsecutive; i++) {
                        currentProd *= grid[row][col+i];
                        coordinates[i] = new int[]{row, col + i};
                        factors[i] = grid[row][col + i];
                    }

                    if (currentProd > maxProd) {
                        maxProd = currentProd;
                        maxProducts.clear();
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));

                    } else if (currentProd == maxProd) {
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));
                    }
                }


                //Vertical product of numConsecutive numbers
                if(row + nConsecutive - 1 < rowDim) {
                    long currentProd = 1;
                    int[][] coordinates = new int[nConsecutive][2];
                    int[] factors = new int[nConsecutive];

                    for (int i = 0; i < nConsecutive; i++) {
                        currentProd *= grid[row+i][col];
                        coordinates[i] = new int[]{row+i, col};
                        factors[i] = grid[row+i][col];
                    }

                    if (currentProd > maxProd) {
                        maxProd = currentProd;
                        maxProducts.clear();
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));

                    } else if (currentProd == maxProd) {
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));
                    }
                }


                //NW to SE product of numConsecutive numbers
                if((col + nConsecutive - 1 < colDim) && (row + nConsecutive - 1 < rowDim)) {
                    long currentProd = 1;
                    int[][] coordinates = new int[nConsecutive][2];
                    int[] factors = new int[nConsecutive];

                    for (int i = 0; i < nConsecutive; i++) {
                        currentProd *= grid[row+i][col+i];
                        coordinates[i] = new int[]{row+i, col+i};
                        factors[i] = grid[row+i][col+i];
                    }

                    if (currentProd > maxProd) {
                        maxProd = currentProd;
                        maxProducts.clear();
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));

                    } else if (currentProd == maxProd) {
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));
                    }
                }


                //NE to SW product of numConsecutive numbers
                if((col - nConsecutive - 1 >= 0) && (row + nConsecutive - 1 < rowDim)) {
                    long currentProd = 1;
                    int[][] coordinates = new int[nConsecutive][2];
                    int[] factors = new int[nConsecutive];

                    for (int i = 0; i < nConsecutive; i++) {
                        currentProd *= grid[row+i][col-i];
                        coordinates[i] = new int[]{row+i, col-i};
                        factors[i] = grid[row+i][col-i];
                    }

                    if (currentProd > maxProd) {
                        maxProd = currentProd;
                        maxProducts.clear();
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));

                    } else if (currentProd == maxProd) {
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));
                    }
                }
            }
        }
        return maxProducts;
    }

    private boolean isSquare(int[][] grid) {
        if (grid == null) return false;
        int rowDim = grid.length;

        for (int[] row : grid) {
            int colDim = row.length;
            if (colDim != rowDim) return false;
        }
        return true;
    }

    private boolean consecutiveNumbersLessOrEqualDim(int[][] grid, int numConsecutive) {
        return grid.length >= numConsecutive;
    }
}
