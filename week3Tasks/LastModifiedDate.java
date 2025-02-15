import java.io.File;
import java.util.Date;

public class LastModifiedDate {
    public static void main(String[] args) {
        File file = new File("/Users/atchaiyarajs/Desktop/Infosys/Pattern.py"); // Replace with your file path

        if (file.exists()) {
            long lastModified = file.lastModified();
            Date date = new Date(lastModified);
            System.out.println("Last modified date: " + date);
        } else {
            System.out.println("The file does not exist.");
        }
    }
}