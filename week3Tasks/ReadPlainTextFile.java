import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadPlainTextFile {
    public static void main(String[] args) {
        File file = new File("/Users/atchaiyarajs/Desktop/Python/StringCalci.py"); // Replace with your file path

        try (Scanner scanner = new Scanner(file)) {
            System.out.println("File content:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist.");
        }
    }
}