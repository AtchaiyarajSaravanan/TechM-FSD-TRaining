import java.io.File;

public class CheckFilePermissions {
    public static void main(String[] args) {
        File file = new File("/Users/atchaiyarajs/Desktop/Infosys/WildCardMatch.py"); 
        if (file.canRead()) {
            System.out.println("The file or directory has read permission.");
        } else {
            System.out.println("The file or directory does not have read permission.");
        }

        if (file.canWrite()) {
            System.out.println("The file or directory has write permission.");
        } else {
            System.out.println("The file or directory does not have write permission.");
        }
    }
}