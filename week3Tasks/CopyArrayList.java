import java.util.ArrayList;

public class CopyArrayList {
    public static void main(String[] args) {
        ArrayList<String> colors1 = new ArrayList<>();
        colors1.add("Red");
        colors1.add("Green");
        colors1.add("Blue");

        ArrayList<String> colors2 = new ArrayList<>(colors1); // Copy list
        System.out.println("Copied list: " + colors2);
    }
}