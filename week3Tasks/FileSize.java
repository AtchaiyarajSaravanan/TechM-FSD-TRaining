import java.io.File;

public class FileSize {
    public static void main(String[] args) {
        File file = new File("/Users/atchaiyarajs/Desktop/Infosys/ATM.py"); 

        if (file.exists()) {
            long sizeInBytes = file.length();
            double sizeInKB = sizeInBytes / 1024.0;
            double sizeInMB = sizeInKB / 1024.0;

            System.out.println("File size in bytes: " + sizeInBytes);
            System.out.println("File size in KB: " + sizeInKB);
            System.out.println("File size in MB: " + sizeInMB);
        } else {
            System.out.println("The file does not exist.");
        }
    }
}