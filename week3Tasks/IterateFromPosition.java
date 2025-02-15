import java.util.LinkedList;
import java.util.ListIterator;

public class IterateFromPosition {
    public static void main(String[] args) {
        LinkedList<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        ListIterator<String> iterator = colors.listIterator(1); // Start from index 1
        System.out.println("Iterating from index 1:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}