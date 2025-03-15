public class MaxProd {
    private final int maxProd;
    private final int[] factors;
    private final int[][] coordinates;

    public MaxProd(int maxProd, int[][] coordinates, int[] factors) {
        this.maxProd = maxProd;
        this.factors = factors;
        this.coordinates = coordinates;
    }

    public int getMaxProd() {
        return maxProd;
    }
    public int[][] getCoordinates() {
        return coordinates;
    }

    public int[] getFactors() {
        return factors;
    }
}
