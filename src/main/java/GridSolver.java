public class GridSolver {
    int numConsecutive;
    long[][] grid;

    public GridSolver(int numConsecutive, long[][] grid) {
        this.numConsecutive = numConsecutive;
        this.grid = grid;
    }

    public long solve() {
        int rowDim = grid.length;
        int colDim = grid[0].length;
        long maxProd = 0;

        for (int row = 0; row < rowDim; row++) {
            for (int col = 0; col < colDim; col++) {

                //Horizontal product of numConsecutive numbers
                if (col + numConsecutive - 1 < colDim) {
                    long currentProd = grid[row][col] *
                            grid[row][col + 1] *
                            grid[row][col + 2] *
                            grid[row][col + 3];

                    if (currentProd > maxProd) maxProd = currentProd;
                }


                //Vertical product of numConsecutive numbers
                if(row + numConsecutive - 1 < rowDim) {
                    long currentProd = grid[row][col] *
                            grid[row + 1][col] *
                            grid[row + 2][col] *
                            grid[row + 3][col];

                    if (currentProd > maxProd) maxProd = currentProd;
                }


                //NW to SE product of numConsecutive numbers
                if((col + numConsecutive - 1 < colDim) && (row + numConsecutive - 1 < rowDim)) {
                    long currentProd = grid[row][col] *
                            grid[row + 1][col + 1] *
                            grid[row + 2][col + 2] *
                            grid[row + 3][col + 3];

                    if (currentProd > maxProd) maxProd = currentProd;
                }


                //NE to SW product of numConsecutive numbers
                if((col - numConsecutive - 1 >= 0) && (row + numConsecutive - 1 < rowDim)) {
                    long currentProd = grid[row][col] *
                            grid[row + 1][col - 1] *
                            grid[row + 2][col - 2] *
                            grid[row + 3][col - 3];

                    if (currentProd > maxProd) maxProd = currentProd;
                }
            }
        }

        return maxProd;
    }
}
