import java.io.File;
import java.io.FilenameFilter;

public class FilterFilesByExtension {
    public static void main(String[] args) {
        File directory = new File("/Users/atchaiyarajs/Desktop/Infosys"); 
        String extension = ".py"; 

        String[] files = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extension);
            }
        });

        if (files != null) {
            System.out.println("Files with extension " + extension + ":");
            for (String file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("No files found with the specified extension.");
        }
    }
}