import java.util.ArrayList;

public class InsertElementAtFirst {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        colors.add(0, "Yellow"); // Insert at the first position
        System.out.println("Updated list: " + colors);
    }
}