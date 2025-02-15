import java.util.Arrays;

public class MultiThreadSortExample {
    public static void main(String[] args) {
        int[] array = {5, 3, 9, 1, 7, 2, 8, 4, 6};

        Thread sortThread = new Thread(() -> {
            Arrays.sort(array);
            System.out.println("Sorted array: " + Arrays.toString(array));
        });

        sortThread.start();
    }
}