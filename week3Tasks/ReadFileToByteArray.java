import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileToByteArray {
    public static void main(String[] args) {
        File file = new File("/Users/atchaiyarajs/Desktop/Python/StringCalci.py"); // Replace with your file path

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] byteArray = new byte[(int) file.length()];
            fis.read(byteArray);

            System.out.println("File content as byte array:");
            for (byte b : byteArray) {
                System.out.print(b + " ");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}