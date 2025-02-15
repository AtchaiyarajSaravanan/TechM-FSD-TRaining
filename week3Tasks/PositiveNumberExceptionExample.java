import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PositiveNumberExceptionExample {
    public static void checkNumbers(String filePath) throws FileNotFoundException, Exception {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number > 0) {
                throw new Exception("Positive number found: " + number);
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            checkNumbers("numbers.txt"); // This will throw an exception if any number is positive
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}