import java.util.ArrayList;

public class SearchElement {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        String searchColor = "Green";
        if (colors.contains(searchColor)) {
            System.out.println(searchColor + " found in the list.");
        } else {
            System.out.println(searchColor + " not found in the list.");
        }
    }
}