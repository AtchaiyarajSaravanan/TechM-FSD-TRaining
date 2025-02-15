import java.io.File;

public class CheckIfDirectoryOrFile {
    public static void main(String[] args) {
        File file = new File("/Users/atchaiyarajs/Desktop/Infosys/DayOfADate.py"); 

        if (file.isDirectory()) {
            System.out.println("The path is a directory.");
        } else if (file.isFile()) {
            System.out.println("The path is a file.");
        } else {
            System.out.println("The path does not exist.");
        }
    }
}