import java.util.LinkedList;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Green");

        String searchColor = "Green";
        int firstIndex = colors.indexOf(searchColor); // First occurrence
        int lastIndex = colors.lastIndexOf(searchColor); // Last occurrence

        System.out.println("First occurrence of " + searchColor + ": " + firstIndex);
        System.out.println("Last occurrence of " + searchColor + ": " + lastIndex);
    }
}