import java.util.ArrayList;

public class RetrieveElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        String element = colors.get(1); // Retrieve element at index 1
        System.out.println("Element at index 1: " + element);
    }
}