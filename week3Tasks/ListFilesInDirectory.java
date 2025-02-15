import java.io.File;

public class ListFilesInDirectory {
    public static void main(String[] args) {
        File directory = new File("/Users/atchaiyarajs/Desktop/Infosys");

        if (!directory.exists()) {
            System.out.println("The directory does not exist: " + directory.getPath());
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The path is not a directory: " + directory.getPath());
            return;
        }

        String[] files = directory.list();

        if (files != null && files.length > 0) {
            System.out.println("Files and directories in " + directory.getPath() + ":");
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("The directory is empty: " + directory.getPath());
        }
    }
}