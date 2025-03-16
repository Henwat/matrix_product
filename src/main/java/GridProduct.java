import java.util.Arrays;
import java.util.Objects;


public record GridProduct(long maxProd, int[][] coordinates, int[] factors) {

    @Override
    public String toString() {
        return "Product: " + maxProd +
                "\nFactors: " + Arrays.toString(factors) +
                "\nCoordinates: " + Arrays.deepToString(coordinates) +
                "\n *Coordinates are in same order as the factors";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GridProduct that)) return false;
        return maxProd == that.maxProd && Objects.deepEquals(factors, that.factors) && Objects.deepEquals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxProd, Arrays.deepHashCode(coordinates), Arrays.hashCode(factors));
    }
}
