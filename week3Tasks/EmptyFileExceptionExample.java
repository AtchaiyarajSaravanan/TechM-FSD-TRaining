import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EmptyFileExceptionExample {
    public static void checkFile(String filePath) throws FileNotFoundException, Exception {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        if (!scanner.hasNextLine()) {
            throw new Exception("File is empty!");
        }

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void main(String[] args) {
        try {
            checkFile("empty.txt"); // This will throw an exception if the file is empty
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}