import java.util.ArrayList;

public class UpdateElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        colors.set(1, "Yellow"); // Update element at index 1
        System.out.println("Updated list: " + colors);
    }
}