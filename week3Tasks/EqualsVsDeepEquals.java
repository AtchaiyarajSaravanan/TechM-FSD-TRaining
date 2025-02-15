import java.util.Arrays;

public class EqualsVsDeepEquals {
    public static void main(String[] args) {
        int[][] array1 = {{1, 2}, {3, 4}};
        int[][] array2 = {{1, 2}, {3, 4}};

        System.out.println("Using equals(): " + Arrays.equals(array1, array2)); // false
        System.out.println("Using deepEquals(): " + Arrays.deepEquals(array1, array2)); // true

        // Explanation:
        // equals() checks if the references are the same or if the arrays are null.
        // deepEquals() checks the contents of the arrays, including nested arrays.
    }
}