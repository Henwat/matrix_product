import java.util.Arrays;


public record GridProduct(long maxProd, int[][] coordinates, int[] factors) {

    @Override
    public String toString() {
        return "Product: " + maxProd +
                "\nFactors: " + Arrays.toString(factors) +
                "\nCoordinates: " + Arrays.deepToString(coordinates) +
                "\n *Coordinates are in same order as the factors";
    }
}
