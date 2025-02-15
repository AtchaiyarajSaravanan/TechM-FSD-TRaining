import java.util.*;
public class MatrixMultiplicationExample {
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};
        int[][] result = new int[2][2];

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        result[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            System.out.println("Resultant matrix:");
            for (int[] row : result) {
                System.out.println(Arrays.toString(row));
            }
        });

        thread.start();
    }
}