package gridanalyzer;

import java.util.ArrayList;
import java.util.List;

public class GridSolver {
    private GridSolver() {
    }

    public static List<GridProduct> solve(int[][] grid, int kConsecutive) {
        //Validating grid and kConsecutive
        if(!checkIfGridIsValid(grid)) {
            throw new IllegalArgumentException("Grid is not valid");
        }
        if(kConsecutive == 0) {
            throw new IllegalArgumentException("kConsecutive should be greater than 0");
        }
        if(!checkIfConsecutiveNumbersLessOrEqualDim(grid, kConsecutive)) {
            throw new IllegalArgumentException("Consecutive numbers must be less than or equal to the dimension");
        }


        //Find the largest product in the matrix
        int rowDim = grid.length;
        int colDim = grid[0].length;
        long maxProd = 0;

        List<GridProduct> maxProducts = new ArrayList<>();

        for (int row = 0; row < rowDim; row++) {
            for (int col = 0; col < colDim; col++) {

                //Horizontal product of kConsecutive numbers
                if (col + kConsecutive - 1 < colDim) {
                    long currentProd = 1;
                    int[][] coordinates = new int[kConsecutive][2];
                    int[] factors = new int[kConsecutive];

                    for (int i = 0; i < kConsecutive; i++) {
                        currentProd *= grid[row][col+i];
                        coordinates[i] = new int[]{row, col + i};
                        factors[i] = grid[row][col + i];
                    }

                    if (currentProd > maxProd) {
                        maxProd = currentProd;
                        maxProducts.clear();
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));

                    } else if (maxProd != 0 && currentProd == maxProd) {
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));
                    }
                }


                //Vertical product of kConsecutive numbers
                if(row + kConsecutive - 1 < rowDim) {
                    long currentProd = 1;
                    int[][] coordinates = new int[kConsecutive][2];
                    int[] factors = new int[kConsecutive];

                    for (int i = 0; i < kConsecutive; i++) {
                        currentProd *= grid[row+i][col];
                        coordinates[i] = new int[]{row+i, col};
                        factors[i] = grid[row+i][col];
                    }

                    if (currentProd > maxProd) {
                        maxProd = currentProd;
                        maxProducts.clear();
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));

                    } else if (maxProd != 0 && currentProd == maxProd) {
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));
                    }
                }


                //NW to SE product of kConsecutive numbers
                if((col + kConsecutive - 1 < colDim) && (row + kConsecutive - 1 < rowDim)) {
                    long currentProd = 1;
                    int[][] coordinates = new int[kConsecutive][2];
                    int[] factors = new int[kConsecutive];

                    for (int i = 0; i < kConsecutive; i++) {
                        currentProd *= grid[row+i][col+i];
                        coordinates[i] = new int[]{row+i, col+i};
                        factors[i] = grid[row+i][col+i];
                    }

                    if (currentProd > maxProd) {
                        maxProd = currentProd;
                        maxProducts.clear();
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));

                    } else if (maxProd != 0 && currentProd == maxProd) {
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));
                    }
                }


                //NE to SW product of kConsecutive numbers
                if((col - kConsecutive + 1 >= 0) && (row + kConsecutive - 1 < rowDim)) {
                    long currentProd = 1;
                    int[][] coordinates = new int[kConsecutive][2];
                    int[] factors = new int[kConsecutive];

                    for (int i = 0; i < kConsecutive; i++) {
                        currentProd *= grid[row+i][col-i];
                        coordinates[i] = new int[]{row+i, col-i};
                        factors[i] = grid[row+i][col-i];
                    }

                    if (currentProd > maxProd) {
                        maxProd = currentProd;
                        maxProducts.clear();
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));

                    } else if (maxProd != 0 && currentProd == maxProd) {
                        maxProducts.add(new GridProduct(currentProd, coordinates, factors));
                    }
                }
            }
        }
        return maxProducts;
    }

    private static boolean checkIfConsecutiveNumbersLessOrEqualDim(int[][] grid, int numConsecutive) {
        return grid.length >= numConsecutive;
    }

    private static boolean checkIfGridIsValid(int[][] grid) {
        if (grid == null) return false;
        if(grid.length == 0) return false;
        if(grid[0].length == 0) return false;
        return true;
    }
}
