import java.util.Arrays;

public class ArrayCopyRangeExample {
    public static void main(String[] args) {
        int[] originalArray = {10, 20, 30, 40, 50, 60, 70};
        int[] copiedArray = Arrays.copyOfRange(originalArray, 2, 5); // Copy from index 2 to 4

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Copied Array (Range 2 to 4): " + Arrays.toString(copiedArray));
    }
}