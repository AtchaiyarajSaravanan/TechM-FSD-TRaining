import java.io.File;

public class CheckFileOrDirectoryExists {
    public static void main(String[] args) {
        File file = new File("/Users/atchaiyarajs/Desktop/Infosys/BooleanExpressionLeetCode.py"); 

        if (file.exists()) {
            System.out.println("The file or directory exists.");
        } else {
            System.out.println("The file or directory does not exist.");
        }
    }
}